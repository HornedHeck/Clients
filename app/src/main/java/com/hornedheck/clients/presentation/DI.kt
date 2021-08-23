package com.hornedheck.clients.presentation

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.hornedheck.clients.presentation.activty.ActivityViewModel
import com.hornedheck.clients.presentation.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {

    viewModel { SplashViewModel(get()) }
    viewModel { ActivityViewModel(get()) }

}


val navigationModule = module {

    single { Cicerone.create() }
    single { get<Cicerone<Router>>().router }
    single { get<Cicerone<Router>>().getNavigatorHolder() }

}