package com.hornedheck.clients.data

import com.hornedheck.clients.data.user.UserDataStorage
import com.hornedheck.clients.domain.user.UsersRepo
import org.koin.dsl.module

val dataModule = module {
    factory<UsersRepo> { UserDataStorage(get()) }
}