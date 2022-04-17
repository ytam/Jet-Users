package io.github.ytam.githubusers.domain.model

data class UserDetail(
    var id: Long,
    var login: String,
    var avatar_url: String,
    var name: String,
    var location: String,
    var followers: Int,
    var following: Int
)
