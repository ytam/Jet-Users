package io.github.ytam.githubusers.data.locale

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.ytam.githubusers.data.locale.dao.UserDao
import io.github.ytam.githubusers.data.locale.dao.UserRemoteKeysDao
import io.github.ytam.githubusers.domain.model.User
import io.github.ytam.githubusers.domain.model.UserRemoteKeys

@Database(
    entities = [User::class, UserRemoteKeys::class],
    version = 1,
    exportSchema = false
)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun userRemoteKeysDao(): UserRemoteKeysDao
}
