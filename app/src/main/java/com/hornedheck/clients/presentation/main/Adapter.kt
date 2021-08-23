package com.hornedheck.clients.presentation.main

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.hornedheck.clients.databinding.ItemUserBinding

// Also we can add DiffUtils Support
fun getMainAdapter(editCallback: (UserItem) -> Unit) = ListDelegationAdapter(
    getUserAdapter(editCallback)
)

private fun getUserAdapter(editCallback: (UserItem) -> Unit) =
    adapterDelegateViewBinding<UserItem, UserItem, ItemUserBinding>(
        { layoutInflater, parent ->
            ItemUserBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        bind {
            binding.edit.setOnClickListener { editCallback(item) }
        }
    }
