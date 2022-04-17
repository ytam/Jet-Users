package io.github.ytam.githubusers.data.repository.datasource

import androidx.paging.PagingData
import io.github.ytam.githubusers.domain.model.User
import io.github.ytam.githubusers.domain.model.UserDetail
import kotlinx.coroutines.flow.Flow

interface UserRemoteDataSource {
    fun getUserList(): Flow<PagingData<User>>

    suspend fun getUserDetailsByUsername(username: String): Flow<UserDetail>
}
