package io.github.ytam.githubusers.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.ytam.githubusers.domain.repository.UserRepository
import io.github.ytam.githubusers.domain.usecase.GetUsersFromDBUseCase
import io.github.ytam.githubusers.domain.usecase.GetUsersUseCase
import io.github.ytam.githubusers.domain.usecase.UserUseCases

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideUserUseCases(userRepository: UserRepository) = UserUseCases(
        getUsersUseCase = GetUsersUseCase(userRepository = userRepository),
        getUsersFromDBUseCase = GetUsersFromDBUseCase(userRepository = userRepository)
    )
}
