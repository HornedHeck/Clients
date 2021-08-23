package com.hornedheck.clients.presentation.main

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hornedheck.clients.R
import com.hornedheck.clients.presentation.core.BaseFragment

class MainFragment : BaseFragment<MainViewModel, MainState>(R.layout.fragment_main) {

    private val adapter by lazy { getMainAdapter(viewModel::editClicked) }

    override fun getViewModelClass() = MainViewModel::class

    override fun updateState(state: MainState) {
        adapter.items = state.items
    }

    companion object {

        val screen = FragmentScreen { MainFragment() }

    }

}