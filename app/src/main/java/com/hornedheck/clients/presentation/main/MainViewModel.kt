package com.hornedheck.clients.presentation.main

import com.github.terrakok.cicerone.Router
import com.hornedheck.clients.domain.user.User
import com.hornedheck.clients.domain.user.UserInteractor
import com.hornedheck.clients.domain.user.getStartUser
import com.hornedheck.clients.presentation.core.BaseViewModel

class MainViewModel(
    router: Router,
    private val userInteractor: UserInteractor
) : BaseViewModel<MainState>(
    MainState(),
    router
) {

    fun editClicked(user: User) {
        userInteractor.setUser(user)
//        router.navigateTo(NameFragment.screen)
    }

    fun addClicked() = editClicked(getStartUser())
}