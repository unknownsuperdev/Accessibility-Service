package com.project.account.main.fragments

import com.project.account.fragment.BaseFragment
import com.project.account.instagramAccessibilityService.InstagramAccessibilityService
import com.project.account.instagramAccessibilityService.isAccessibilityServiceEnabled
import com.project.account.instagramAccessibilityService.redirectToInstagramApplication
import com.project.account.main.fragments.adapter.model.HuntedAccountAdapter
import androidx.core.view.isVisible
import by.kirich1409.viewbindingdelegate.viewBinding
import com.project.accountfeatures.main.R
import com.project.accountfeatures.main.databinding.MainFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment :
    BaseFragment<MainStateUi, MainViewModel, MainFragmentBinding>(
        R.layout.main_fragment
    ) {
    override val viewModel: MainViewModel by viewModel()
    override val binding: MainFragmentBinding by viewBinding()
    private val huntedAccountAdapter by lazy { HuntedAccountAdapter() }

    override fun collectState(newState: MainStateUi) {
        with(binding) {
            when (newState) {
                is MainStateUi.READY -> {
                    progressBar.isVisible = false
                    errorText.isVisible = false
                    rvAccounts.isVisible = true
                }

                is MainStateUi.LOADING -> {
                    progressBar.isVisible = true
                    errorText.isVisible = false
                    rvAccounts.isVisible = false
                }

                is MainStateUi.Error -> {
                    progressBar.isVisible = false
                    rvAccounts.isVisible = false
                    errorText.isVisible = true
                }
            }
        }
    }

    override fun initView() {
        binding.rvAccounts.adapter = huntedAccountAdapter
    }

    override fun initListeners() {
        with(binding) {
            startButton.setOnClickListener {
                requireActivity().run {
                    if (isAccessibilityServiceEnabled(InstagramAccessibilityService::class.java)
                    ) {
                        redirectToInstagramApplication()
                    }
                }
            }
        }
    }

    override fun collectFlows() {
        with(viewModel) {
            collectFlow(accountItemsStateFlow, huntedAccountAdapter::submitList)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllInstagramAccounts()
    }
}