package io.github.ytam.githubusers.data.repository

import androidx.paging.PagingData
import io.github.ytam.githubusers.data.repository.datasource.UserRemoteDataSource
import io.github.ytam.githubusers.domain.model.User
import io.github.ytam.githubusers.domain.model.UserDetail
import io.github.ytam.githubusers.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(
    private val userRemoteDataSource: UserRemoteDataSource
) : UserRepository {

    override fun getAllUser(): Flow<PagingData<User>> = userRemoteDataSource.getUserList()

    override suspend fun getUserDetailsByUsername(username: String): UserDetail =
        userRemoteDataSource.getUserDetailsByUsername(username)
}
