package com.project.account.app

import com.project.account.di.dataBaseModule
import com.project.account.di.providerModule
import com.project.account.di.repositoryModule
import com.project.account.di.viewModelModule
import com.project.account.di.accountUseCase
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(modules)
        }
    }

    private val modules = listOf(
        viewModelModule,
        repositoryModule,
        dataBaseModule,
        providerModule,
        accountUseCase
    )
}