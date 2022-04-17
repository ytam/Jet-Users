package io.github.ytam.githubusers.domain.repository

import androidx.paging.PagingData
import io.github.ytam.githubusers.domain.model.User
import io.github.ytam.githubusers.domain.model.UserDetail
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getAllUser(): Flow<PagingData<User>>

    suspend fun getUserDetailsByUsername(username: String): Flow<UserDetail>
}
