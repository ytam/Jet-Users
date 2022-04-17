package io.github.ytam.githubusers.data.repository.datasource

import io.github.ytam.githubusers.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserLocalDataSource {
    fun getUsersFromDB(userId: Int): Flow<User>
}
