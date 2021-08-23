package com.hornedheck.clients.presentation.splash

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hornedheck.clients.R
import com.hornedheck.clients.presentation.core.BaseFragment

class SplashFragment : BaseFragment<SplashViewModel, SplashState>(
    R.layout.fragment_splash
) {

    override fun getViewModelClass() = SplashViewModel::class

    override fun updateState(state: SplashState) {
//        No action
    }

    companion object {

        val screen = FragmentScreen { SplashFragment() }

    }
}