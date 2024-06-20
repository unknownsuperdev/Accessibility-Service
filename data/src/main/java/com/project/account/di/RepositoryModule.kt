package com.project.account.di

import com.project.account.repository.AccountRepositoryImpl
import com.project.account.repository.AccountRepository
import org.koin.dsl.module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf

val repositoryModule = module {
    singleOf(::AccountRepositoryImpl) { bind<AccountRepository>() }
}