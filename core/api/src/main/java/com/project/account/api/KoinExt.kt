package com.project.account.api

import org.koin.java.KoinJavaComponent.inject
inline fun <reified T> inject(): Lazy<T> { return inject(T::class.java) }