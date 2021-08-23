package com.hornedheck.clients.presentation.splash

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hornedheck.clients.databinding.FragmentSplashBinding
import com.hornedheck.clients.presentation.core.BaseFragment

class SplashFragment : BaseFragment<SplashViewModel, SplashState, FragmentSplashBinding>() {

    override fun inflate(inflater: LayoutInflater, root: ViewGroup?) =
        FragmentSplashBinding.inflate(inflater, root, false)

    override fun getViewModelClass() = SplashViewModel::class

    override fun FragmentSplashBinding.updateState(state: SplashState) {
//        No action
    }

    companion object {

        val screen = FragmentScreen { SplashFragment() }

    }
}