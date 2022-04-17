package io.github.ytam.githubusers.domain.usecase

data class UserUseCases(
    val getUsersUseCase: GetUsersUseCase,
    val getUsersFromDBUseCase: GetUsersFromDBUseCase,
)
