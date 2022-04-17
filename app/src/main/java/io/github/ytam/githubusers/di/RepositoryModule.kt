package io.github.ytam.githubusers.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.ytam.githubusers.data.repository.UserRepositoryImpl
import io.github.ytam.githubusers.data.repository.datasource.UserRemoteDataSource
import io.github.ytam.githubusers.domain.repository.UserRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideUserRepository(
        userRemoteDataSource: UserRemoteDataSource
    ): UserRepository =
        UserRepositoryImpl(userRemoteDataSource)
}
