package com.project.account.database.core.dao

import com.project.account.database.core.dao.accountsDao.AccountDao
import com.project.account.database.core.dao.accountsDao.AccountEntity
import androidx.room.Database
import androidx.room.RoomDatabase

private const val DATABASE_VERSION = 1

@Database(
    entities = [AccountEntity::class],
    version = DATABASE_VERSION,
    exportSchema = true
)
abstract class AccountDataBase : RoomDatabase() {
    abstract fun instagramAccountDao(): AccountDao

    companion object {
        const val DATABASE_NAME = "account_database"
    }
}