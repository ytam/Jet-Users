package io.github.ytam.githubusers.domain.usecase

import io.github.ytam.githubusers.domain.model.UserDetail
import io.github.ytam.githubusers.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUsersFromDBUseCase(private val userRepository: UserRepository) {

    suspend operator fun invoke(username: String): Flow<UserDetail> =
        userRepository.getUserDetailsByUsername(username)
}
