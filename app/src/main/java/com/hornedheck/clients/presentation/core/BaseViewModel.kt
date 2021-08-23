package com.hornedheck.clients.presentation.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<S : BaseState>(
    baseState: S,
    protected val router: Router
) : ViewModel() {

    protected val _stateFlow = MutableStateFlow(baseState)
    val stateFlow: StateFlow<S> = _stateFlow

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }


}