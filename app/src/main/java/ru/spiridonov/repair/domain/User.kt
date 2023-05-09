package ru.spiridonov.repair.domain

data class User(
    val user_id: String,
    val email: String,
    val passwordHash: String? = null,
    val username: String,
    val dateCreated: String,
    val accessToken: String
)
