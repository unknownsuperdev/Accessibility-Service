package com.project.account.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

@Suppress("FunctionName")
fun ApplicationScope() = CoroutineScope(SupervisorJob() + Dispatchers.Default)
