package io.github.ytam.githubusers.data.locale.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.ytam.githubusers.domain.model.UserRemoteKeys

@Dao
interface UserRemoteKeysDao {

    @Query("SELECT * FROM user_remote_keys WHERE id = :userId")
    suspend fun getUserRemoteKeys(userId: Int): UserRemoteKeys?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllUserRemoteKeys(userRemoteKeys: List<UserRemoteKeys>)

    @Query("DELETE FROM user_remote_keys")
    suspend fun deleteAllUserRemoteKeys()
}
