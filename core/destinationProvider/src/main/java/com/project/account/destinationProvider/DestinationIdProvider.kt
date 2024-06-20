package com.project.account.destinationProvider

import androidx.annotation.IdRes

interface DestinationIdProvider {
    @get:IdRes
    val mainScreenID: Int
}