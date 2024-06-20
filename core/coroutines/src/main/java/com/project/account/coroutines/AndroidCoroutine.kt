package com.project.account.coroutines

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

fun <T> Flow<T>.subscribe(
    owner: LifecycleOwner,
    action: (value: T) -> Unit
) {
    owner.lifecycleScope.launch {
        owner.lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED) {
            collect { action.invoke(it) }
        }
    }
}

fun <T> Flow<T>.subscribeWhenResumed(
    owner: LifecycleOwner,
    action: (value: T) -> Unit
) {
    owner.lifecycleScope.launch {
        owner.lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
            collect { action.invoke(it) }
        }
    }
}

fun <T> Flow<T>.subscribeWhenStarted(
    owner: LifecycleOwner,
    action: (value: T) -> Unit
) {
    owner.lifecycleScope.launch {
        owner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            collect { action.invoke(it) }
        }
    }
}

@Suppress("FunctionName")
fun <T> SingleReplaySharedFlow(
    extraBufferCapacity: Int = 0,
    onBufferOverflow: BufferOverflow = BufferOverflow.SUSPEND
) = MutableSharedFlow<T>(
    replay = 1,
    extraBufferCapacity = extraBufferCapacity,
    onBufferOverflow = onBufferOverflow
)

fun <T> MutableSharedFlow<T>.tryEmitScope(
    scope: CoroutineScope,
    value: T
) {
    scope.launch {
        emit(value)
    }
}