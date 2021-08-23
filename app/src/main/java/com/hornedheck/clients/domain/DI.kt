package com.hornedheck.clients.domain

import com.hornedheck.clients.domain.user.UserInteractor
import org.koin.dsl.module

val interactorModule = module {
    single { UserInteractor(get()) }
}