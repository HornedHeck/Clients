package com.hornedheck.clients.presentation.main

import com.hornedheck.clients.domain.user.User
import com.hornedheck.clients.presentation.core.BaseState
import com.hornedheck.clients.presentation.core.StateModel
import kotlinx.android.parcel.Parcelize
import java.time.LocalDate

@Parcelize
data class MainState(
    val isInProgress: Boolean = true,
    val items: List<UserItem> = emptyList()
) : BaseState

@Parcelize
data class UserItem(
    val id: Int,
    val name: String,
    val birthday: LocalDate,
    val weight: Double,
    val photo: String
) : StateModel

fun UserItem.toEntity() = User(id, name, birthday, weight, photo)
fun User.toState() = UserItem(id, name, birthday, weight, photo)