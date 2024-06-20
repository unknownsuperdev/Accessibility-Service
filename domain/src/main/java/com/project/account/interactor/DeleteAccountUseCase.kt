package com.project.account.interactor

import com.project.account.model.Account
import com.project.account.repository.AccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

interface DeleteAccountUseCase {
    suspend fun invoke(account: Account): Flow<Unit>
}

class DeleteAccountUseCaseImpl(
    private val accountRepository: AccountRepository
) : DeleteAccountUseCase {
    override suspend fun invoke(account: Account) =
        accountRepository.delete(account).flowOn(Dispatchers.IO)
}