package com.hornedheck.clients.data.utils

import android.content.Context
import com.hornedheck.clients.domain.utils.ResourceProvider

class ResourceProviderImpl(
    private val context: Context
) : ResourceProvider {

    override fun getString(id: Int) = context.getString(id)
}