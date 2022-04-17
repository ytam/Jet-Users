package io.github.ytam.githubusers.data.remote

import io.github.ytam.githubusers.domain.model.User
import io.github.ytam.githubusers.domain.model.UserDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {

    /**
     * all users network call
     */
    @GET("/users")
    suspend fun getAllUser(
        @Query("since") page: Int
    ): Response<List<User>>

    /**
     * one user details network call
     */
    @GET("/users/{username}")
    suspend fun getUserByUsername(
        @Path("username") username: String,
    ): UserDetail
}
