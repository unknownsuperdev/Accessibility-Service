package com.project.account.main.fragments

import com.project.account.api.EMPTY_STRING
import com.project.account.coroutines.subscribe
import com.project.account.destinationProvider.DestinationIdProvider
import com.project.account.interactor.GetAllAccountsUseCase
import com.project.account.main.fragments.adapter.model.HuntedAccount
import com.project.account.main.fragments.adapter.model.toHuntedAccount
import com.project.account.viewModel.BaseViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val destinationIdProvider: DestinationIdProvider,
    private val getAllAccountsUseCase: GetAllAccountsUseCase
) : BaseViewModel<MainStateUi>() {

    private val _accountItemsMutableStateFlow =
        MutableStateFlow<List<HuntedAccount>>(emptyList())
    val accountItemsStateFlow: StateFlow<List<HuntedAccount>> =
        _accountItemsMutableStateFlow

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        updateState(
            MainStateUi.Error(
                exception.localizedMessage.orEmpty()
            )
        )
    }


    override fun initState() = MainStateUi.LOADING

    fun getAllInstagramAccounts() {
        updateState(MainStateUi.LOADING)
        viewModelScope.launch(exceptionHandler) {
            getAllAccountsUseCase.invoke().subscribe {
                _accountItemsMutableStateFlow.emit(it.map { it.toHuntedAccount() })
                updateState(
                    if (it.isEmpty()) {
                        MainStateUi.Error(EMPTY_STRING)
                    } else {
                        MainStateUi.READY
                    }
                )
            }
        }
    }
}