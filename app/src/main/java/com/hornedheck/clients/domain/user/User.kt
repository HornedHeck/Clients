package com.hornedheck.clients.domain.user

import java.time.LocalDate

data class User(
    val id: Int,
    val name: String,
    val birthday: LocalDate,
    val weight: Double,
    val photo: String
)

fun getStartUser() = User(
    0, "", LocalDate.now(), 0.0, ""
)
