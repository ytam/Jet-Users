package io.github.ytam.githubusers.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.ytam.githubusers.data.locale.UserDatabase
import io.github.ytam.githubusers.data.locale.dao.UserDao
import io.github.ytam.githubusers.data.locale.dao.UserRemoteKeysDao

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(app: Application): UserDatabase =
        Room.databaseBuilder(app, UserDatabase::class.java, "user_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideUserDao(userDB: UserDatabase): UserDao = userDB.userDao()

    @Provides
    fun provideUserRemoteKeysDao(userDB: UserDatabase): UserRemoteKeysDao =
        userDB.userRemoteKeysDao()
}
