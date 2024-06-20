package com.project.account.fragment

import com.project.account.coroutines.subscribe
import com.project.account.viewModel.BaseStateUi
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.project.account.viewModel.BaseViewModel
import androidx.annotation.LayoutRes
import androidx.navigation.Navigation
import kotlinx.coroutines.flow.Flow

abstract class BaseFragment<State : BaseStateUi, ViewModel : BaseViewModel<State>, ViewBind : ViewBinding>(
    @LayoutRes contentLayoutRes: Int
) : Fragment(contentLayoutRes) {

    abstract val viewModel: ViewModel
    abstract val binding: ViewBind

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.initNavController(Navigation.findNavController(view))
        super.onViewCreated(view, savedInstanceState)
        collectFlows()
        viewModel.stateUi.subscribe(viewLifecycleOwner,::collectState)
        initView()
        initListeners()
    }

    protected open fun initView() {}

    protected open fun initListeners() {}

    protected open fun collectFlows() {}

    protected abstract fun collectState(newState: State)

    protected inline fun <reified T> collectFlow(flow: Flow<T>, crossinline action: (T) -> Unit) = view?.run {
        if (!this@BaseFragment.isAdded) return@run
        flow.subscribe(viewLifecycleOwner) { action(it ?: return@subscribe) }
    }

}