package com.hornedheck.clients.presentation.splash

import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import com.hornedheck.clients.presentation.core.BaseViewModel
import com.hornedheck.clients.presentation.main.MainFragment
import kotlinx.coroutines.launch

class SplashViewModel(
    restoredState: SplashState?,
    router: Router
) : BaseViewModel<SplashState>(
    restoredState ?: SplashState(),
    router
) {

    init {
        viewModelScope.launch {

//            loadData


            router.newRootScreen(MainFragment.screen)
        }
    }


}