package io.github.ytam.githubusers.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.ytam.githubusers.data.locale.dao.UserDao
import io.github.ytam.githubusers.data.repository.datasource.UserLocalDataSource
import io.github.ytam.githubusers.data.repository.datasourceimpl.UserLocalDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideLocalDataSource(userDao: UserDao): UserLocalDataSource =
        UserLocalDataSourceImpl(userDao = userDao)
}
