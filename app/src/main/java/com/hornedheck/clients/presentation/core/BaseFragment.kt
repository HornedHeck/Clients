package com.hornedheck.clients.presentation.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import kotlin.reflect.KClass

private const val BUNDLE_STATE_KEY = "state"

abstract class BaseFragment<VM : BaseViewModel<S>, S : BaseState, VB : ViewBinding> : Fragment() {

    protected lateinit var binding: VB

    protected abstract fun inflate(inflater: LayoutInflater, root: ViewGroup?): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflate(inflater, container)
        return binding.root
    }

    abstract fun getViewModelClass(): KClass<VM>

    protected open val viewModel by viewModel(clazz = getViewModelClass()) {
        parametersOf(
            restoredState
        )
    }

    private var restoredState: S? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        restoredState = savedInstanceState?.getParcelable(BUNDLE_STATE_KEY)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            viewModel.stateFlow.collect {
                restoredState = it
                binding.updateState(it)
            }
        }

    }

    protected abstract fun VB.updateState(state: S)

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(BUNDLE_STATE_KEY, restoredState)
    }
}