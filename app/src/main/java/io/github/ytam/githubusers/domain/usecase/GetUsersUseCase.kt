package io.github.ytam.githubusers.domain.usecase

import io.github.ytam.githubusers.domain.repository.UserRepository

class GetUsersUseCase(private val userRepository: UserRepository) {

    operator fun invoke() = userRepository.getAllUser()
}
