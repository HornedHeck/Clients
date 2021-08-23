package com.hornedheck.clients.data

import com.hornedheck.clients.data.user.UserDataStorage
import com.hornedheck.clients.data.utils.ResourceProviderImpl
import com.hornedheck.clients.domain.user.UsersRepo
import com.hornedheck.clients.domain.utils.ResourceProvider
import org.koin.dsl.module

val dataModule = module {
    factory<UsersRepo> { UserDataStorage(get()) }
    factory<ResourceProvider> { ResourceProviderImpl(get()) }
}