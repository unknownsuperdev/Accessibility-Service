package com.project.account.main.fragments.adapter.model

import com.project.account.adapter.DiffUtilModel
import com.project.account.model.Account

class HuntedAccount(
    override val id: Long,
    val userName: String,
    val password: String
) : DiffUtilModel<Long>()


fun Account.toHuntedAccount() = HuntedAccount(
    id = id,
    userName = userName,
    password = password
)