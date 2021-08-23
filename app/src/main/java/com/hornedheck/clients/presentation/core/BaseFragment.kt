package com.hornedheck.clients.presentation.core

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import kotlin.reflect.KClass

private const val BUNDLE_STATE_KEY = "state"

abstract class BaseFragment<VM : BaseViewModel<S>, S : BaseState>(
    @LayoutRes layoutRes: Int,
) : Fragment(
    layoutRes
) {

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
                updateState(it)
            }
        }

    }

    abstract fun updateState(state: S)

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(BUNDLE_STATE_KEY, restoredState)
    }
}