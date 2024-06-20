package com.project.account.repository

import com.project.account.model.Account
import kotlinx.coroutines.flow.Flow

interface AccountRepository {
    suspend fun getAllAccounts(): Flow<List<Account>>
    suspend fun insertOrReplace(userName: String, password: String): Flow<Unit>
    suspend fun delete(account: Account): Flow<Unit>
}