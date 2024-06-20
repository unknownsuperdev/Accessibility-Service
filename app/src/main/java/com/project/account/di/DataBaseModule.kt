package com.project.account.di

import com.project.account.database.core.dao.AccountDataBase
import androidx.room.Room
import org.koin.dsl.module

val dataBaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AccountDataBase::class.java,
            AccountDataBase.DATABASE_NAME
        )
//        .addMigrations(Migration_1_2())
            .build()
    }
}