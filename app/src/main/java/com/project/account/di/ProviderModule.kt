package com.project.account.di

import com.project.account.destinationProvider.DestinationIdProvider
import org.koin.core.module.dsl.bind
import com.project.account.navigator.DestinationProviderImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val providerModule = module {
    singleOf(::DestinationProviderImpl) { bind<DestinationIdProvider>() }
}