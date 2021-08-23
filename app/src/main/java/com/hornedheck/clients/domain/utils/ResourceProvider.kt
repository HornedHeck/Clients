package com.hornedheck.clients.domain.utils

import androidx.annotation.StringRes

interface ResourceProvider {

    fun getString(@StringRes id: Int): String


}