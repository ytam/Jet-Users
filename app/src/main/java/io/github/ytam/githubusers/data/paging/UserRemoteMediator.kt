package io.github.ytam.githubusers.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import io.github.ytam.githubusers.data.locale.UserDatabase
import io.github.ytam.githubusers.data.remote.GithubApi
import io.github.ytam.githubusers.domain.model.User
import io.github.ytam.githubusers.domain.model.UserRemoteKeys

@OptIn(ExperimentalPagingApi::class)
class UserRemoteMediator(private val githubApi: GithubApi, private val userDB: UserDatabase) :
    RemoteMediator<Int, User>() {

    private val userDao = userDB.userDao()
    private val userRemoteKeysDao = userDB.userRemoteKeysDao()

    override suspend fun load(loadType: LoadType, state: PagingState<Int, User>): MediatorResult {
        return try {
            val page = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }
                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    prevPage
                }
                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    nextPage
                }
            }
            val response = githubApi.getAllUser(page = page)
            var endOfPaginationReached = false
            if (response.isSuccessful) {
                val responseData = response.body()
                endOfPaginationReached = responseData == null
                responseData?.let {
                    userDB.withTransaction {
                        if (loadType == LoadType.REFRESH) {
                            userDao.deleteAllUsers()
                            userRemoteKeysDao.deleteAllUserRemoteKeys()
                        }
                        var prevPage: Int?
                        var nextPage: Int

                        responseData.last().id.let { pageNumber ->
                            nextPage = pageNumber + 1
                            prevPage = if (pageNumber <= 1) null else pageNumber - 1
                        }

                        val keys = responseData.map { user ->
                            UserRemoteKeys(
                                id = user.id,
                                prevPage = prevPage,
                                nextPage = nextPage,
                                lastUpdated = System.currentTimeMillis()
                            )
                        }
                        userRemoteKeysDao.addAllUserRemoteKeys(userRemoteKeys = keys)
                        userDao.addUsers(users = responseData)
                    }
                }
            }
            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, User>,
    ): UserRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                userRemoteKeysDao.getUserRemoteKeys(userId = id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, User>,
    ): UserRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { user ->
                userRemoteKeysDao.getUserRemoteKeys(userId = user.id)
            }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, User>,
    ): UserRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { user ->
                userRemoteKeysDao.getUserRemoteKeys(userId = user.id)
            }
    }
}
