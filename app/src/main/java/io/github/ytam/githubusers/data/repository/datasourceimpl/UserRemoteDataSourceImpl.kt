package io.github.ytam.githubusers.data.repository.datasourceimpl

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import io.github.ytam.githubusers.data.locale.UserDatabase
import io.github.ytam.githubusers.data.paging.UserRemoteMediator
import io.github.ytam.githubusers.data.remote.GithubApi
import io.github.ytam.githubusers.data.repository.datasource.UserRemoteDataSource
import io.github.ytam.githubusers.domain.model.User
import io.github.ytam.githubusers.domain.model.UserDetail
import kotlinx.coroutines.flow.Flow

class UserRemoteDataSourceImpl(
    private val githubApi: GithubApi,
    private val userDatabase: UserDatabase
) : UserRemoteDataSource {

    private val userDao = userDatabase.userDao()

    @OptIn(ExperimentalPagingApi::class)
    override fun getUserList(): Flow<PagingData<User>> {
        val pagingSourceFactory = { userDao.getAllUsers() }
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = UserRemoteMediator(
                githubApi,
                userDatabase
            ),
            pagingSourceFactory = pagingSourceFactory,
        ).flow
    }

    override suspend fun getUserDetailsByUsername(username: String): Flow<UserDetail> =
        githubApi.getUserByUsername(username)
}
