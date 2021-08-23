package com.hornedheck.clients.presentation.main

import com.hornedheck.clients.domain.user.User
import com.hornedheck.clients.presentation.core.BaseState
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainState(
    val isInProgress: Boolean = true,
    val items: List<User> = emptyList()
) : BaseState