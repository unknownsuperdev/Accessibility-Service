package com.project.account.main.fragments

import com.project.account.viewModel.BaseStateUi

sealed class MainStateUi : BaseStateUi {
    data object READY : MainStateUi()
    data object LOADING : MainStateUi()
    data class Error(val msg: String) : MainStateUi()
}
