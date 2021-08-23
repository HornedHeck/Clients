package com.hornedheck.clients.domain.user

class UserInteractor(
    private val usersRepo: UsersRepo
) {

    private var user = getStartUser()

    fun setUser(user: User = getStartUser()) {
        this.user = user
    }

}