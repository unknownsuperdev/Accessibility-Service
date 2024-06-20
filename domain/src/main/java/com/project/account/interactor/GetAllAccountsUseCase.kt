package com.project.account.interactor

import com.project.account.model.Account
import com.project.account.repository.AccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

interface GetAllAccountsUseCase {
    suspend fun invoke(): Flow<List<Account>>
}

class GetAllAccountsUseCaseImpl(
    private val accountRepository: AccountRepository
) : GetAllAccountsUseCase {
    override suspend fun invoke() =
        accountRepository.getAllAccounts().flowOn(Dispatchers.IO)
}