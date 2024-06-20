package com.project.account.repository

import com.project.account.api.DEFAULT_LONG
import com.project.account.coroutines.emitFlow
import com.project.account.database.core.dao.AccountDataBase
import com.project.account.database.core.dao.accountsDao.AccountEntity
import com.project.account.model.Account
import com.project.account.database.core.dao.accountsDao.toInstagramAccount
import com.project.account.database.core.dao.accountsDao.toInstagramAccountEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AccountRepositoryImpl(dataBase: AccountDataBase) : AccountRepository {
    private val instagramAccountDao = dataBase.instagramAccountDao()

    override suspend fun getAllAccounts(): Flow<List<Account>> =
        instagramAccountDao.getAll().map { it.map { it.toInstagramAccount() } }

    override suspend fun insertOrReplace(userName: String, password: String) = emitFlow {
        instagramAccountDao.insertOrReplace(
            AccountEntity(
                DEFAULT_LONG,
                userName,
                password
            )
        )
    }

    override suspend fun delete(account: Account) = emitFlow {
        instagramAccountDao.delete(account.toInstagramAccountEntity())
    }


}