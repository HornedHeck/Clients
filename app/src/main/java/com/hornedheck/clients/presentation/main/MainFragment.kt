package com.hornedheck.clients.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hornedheck.clients.databinding.FragmentMainBinding
import com.hornedheck.clients.presentation.core.BaseFragment

class MainFragment : BaseFragment<MainViewModel, MainState, FragmentMainBinding>() {

    override fun inflate(inflater: LayoutInflater, root: ViewGroup?) =
        FragmentMainBinding.inflate(inflater, root, false)

    override fun getViewModelClass() = MainViewModel::class

    private val adapter by lazy { getMainAdapter(viewModel::editClicked) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.items.adapter = adapter
        binding.items.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )

        binding.add.setOnClickListener { viewModel.addClicked() }
    }

    override fun FragmentMainBinding.updateState(state: MainState) {
        adapter.items = state.items
        items.isVisible = state.items.isNotEmpty()
        empty.isVisible = state.items.isEmpty()
    }

    companion object {

        val screen = FragmentScreen { MainFragment() }

    }

}