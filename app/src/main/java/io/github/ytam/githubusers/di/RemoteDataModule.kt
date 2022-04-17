package io.github.ytam.githubusers.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.ytam.githubusers.data.locale.UserDatabase
import io.github.ytam.githubusers.data.remote.GithubApi
import io.github.ytam.githubusers.data.repository.datasource.UserRemoteDataSource
import io.github.ytam.githubusers.data.repository.datasourceimpl.UserRemoteDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideUserRemoteDataSource(
        githubApi: GithubApi,
        userDatabase: UserDatabase
    ): UserRemoteDataSource =
        UserRemoteDataSourceImpl(githubApi, userDatabase = userDatabase)
}
