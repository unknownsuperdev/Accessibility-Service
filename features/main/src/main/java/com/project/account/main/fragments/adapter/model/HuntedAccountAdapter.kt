package com.project.account.main.fragments.adapter.model

import com.project.account.adapter.BaseAdapter
import com.project.account.adapter.BaseViewHolder
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.project.accountfeatures.main.R
import com.project.accountfeatures.main.databinding.AccountItemBinding

private const val NAME_ID ="ID: "
private const val NAME_USERNAME ="UserName: "
private const val NAME_PASSWORD ="Password: "

class HuntedAccountAdapter :
    BaseAdapter<AccountItemBinding, HuntedAccount, HuntedAccountAdapter.HuntedAccountVoewHolder>() {

    inner class HuntedAccountVoewHolder(private val binding: AccountItemBinding) :
        BaseViewHolder<HuntedAccount, AccountItemBinding>(binding) {
        @SuppressLint("SetTextI18n")
        override fun bind(item: HuntedAccount, context: Context) {
            with(binding) {
                accountId.text = NAME_ID + item.id
                userName.text = NAME_USERNAME + item.userName
                password.text = NAME_PASSWORD + item.password
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HuntedAccountVoewHolder(
        AccountItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.account_item, parent, false)
        )
    )
}