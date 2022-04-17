package io.github.ytam.githubusers.data.repository.datasourceimpl

import io.github.ytam.githubusers.data.locale.dao.UserDao
import io.github.ytam.githubusers.data.repository.datasource.UserLocalDataSource
import io.github.ytam.githubusers.domain.model.User
import kotlinx.coroutines.flow.Flow

class UserLocalDataSourceImpl(private val userDao: UserDao) : UserLocalDataSource {

    override fun getUsersFromDB(userId: Int): Flow<User> = userDao.getUser(userId)
}
