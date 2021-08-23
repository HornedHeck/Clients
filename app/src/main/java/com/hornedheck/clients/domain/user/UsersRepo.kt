package com.hornedheck.clients.domain.user

interface UsersRepo {

    suspend fun getUsers(): List<User>

    suspend fun saveUser(user: User)

}