package com.project.account.di

import com.project.account.interactor.DeleteAccountUseCase
import com.project.account.interactor.GetAllAccountsUseCase
import com.project.account.interactor.InsertOrUpdateAccountUseCase
import com.project.account.interactor.DeleteAccountUseCaseImpl
import com.project.account.interactor.GetAllAccountsUseCaseImpl
import com.project.account.interactor.InsertOrUpdateAccountUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val accountUseCase = module {
    singleOf(::GetAllAccountsUseCaseImpl) { bind<GetAllAccountsUseCase>() }
    singleOf(::InsertOrUpdateAccountUseCaseImpl) { bind<InsertOrUpdateAccountUseCase>() }
    singleOf(::DeleteAccountUseCaseImpl) { bind<DeleteAccountUseCase>() }
}