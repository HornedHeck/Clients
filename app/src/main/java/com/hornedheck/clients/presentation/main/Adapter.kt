package com.hornedheck.clients.presentation.main

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.hornedheck.clients.databinding.ItemUserBinding
import com.hornedheck.clients.domain.user.User

// Also we can add DiffUtils Support
fun getMainAdapter(editCallback: (User) -> Unit) = ListDelegationAdapter(
    getUserAdapter(editCallback)
)

private fun getUserAdapter(editCallback: (User) -> Unit) =
    adapterDelegateViewBinding<User, User, ItemUserBinding>(
        { layoutInflater, parent ->
            ItemUserBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        bind {
            binding.edit.setOnClickListener { editCallback(item) }
        }
    }