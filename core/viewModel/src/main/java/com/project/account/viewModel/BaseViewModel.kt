package com.project.account.viewModel

import com.project.account.coroutines.tryEmitScope
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.navOptions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.android.R

abstract class BaseViewModel<State : BaseStateUi> : ViewModel() {
    private lateinit var _navController: NavController
    protected val navController by lazy { _navController }

    private val _stateUi = MutableStateFlow(initState())
    val stateUi: StateFlow<State> = _stateUi

    protected abstract fun initState(): State

    protected fun updateState(newSate: State) =
        _stateUi.tryEmitScope(viewModelScope, newSate)

    fun initNavController(navController: NavController) {
        if (!isNavControllerInitialized()) {
            _navController = navController
        }
    }

    protected fun navigateTo(@IdRes destinationId: Int, bundle: Bundle = bundleOf()) {
        if (!isNavControllerInitialized()) return
        navController.navigate(destinationId, bundle, getNavOptions())
    }

    private fun getNavOptions() = navOptions {
        anim {
            exit = R.anim.abc_fade_out
            enter = R.anim.abc_fade_in
            popExit = R.anim.abc_fade_out
            popEnter = R.anim.abc_fade_in
        }
    }

    private fun isNavControllerInitialized() = this::_navController.isInitialized
}