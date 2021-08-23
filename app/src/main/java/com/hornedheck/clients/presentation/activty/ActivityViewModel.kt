package com.hornedheck.clients.presentation.activty

import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import com.hornedheck.clients.presentation.core.BaseViewModel
import com.hornedheck.clients.presentation.splash.SplashFragment
import kotlinx.coroutines.cancel

class ActivityViewModel(router: Router) : BaseViewModel<ActivityState>(ActivityState(), router) {


    init {
        router.newRootScreen(SplashFragment.screen)
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }


}