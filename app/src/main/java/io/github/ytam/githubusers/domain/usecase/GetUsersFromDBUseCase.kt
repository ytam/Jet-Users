package io.github.ytam.githubusers.domain.usecase

import io.github.ytam.githubusers.domain.repository.UserRepository

class GetUsersFromDBUseCase(private val userRepository: UserRepository) {

    suspend operator fun invoke(username: String) = userRepository.getUserDetailsByUsername(username)
}
