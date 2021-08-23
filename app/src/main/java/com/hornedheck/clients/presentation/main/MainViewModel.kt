package com.hornedheck.clients.presentation.main

import com.github.terrakok.cicerone.Router
import com.hornedheck.clients.domain.user.User
import com.hornedheck.clients.domain.user.UserInteractor
import com.hornedheck.clients.domain.user.getStartUser
import com.hornedheck.clients.presentation.core.BaseViewModel

class MainViewModel(
    restoredState: MainState?,
    router: Router,
    private val userInteractor: UserInteractor
) : BaseViewModel<MainState>(
    restoredState ?: MainState(),
    router
) {

    private fun editInternal(user: User) {
        userInteractor.setUser(user)
//        router.navigateTo(NameFragment.screen)
    }

    fun editClicked(user: UserItem) = editInternal(user.toEntity())

    fun addClicked() = editInternal(getStartUser())
}