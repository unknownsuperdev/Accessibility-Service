package com.project.account.interactor

import com.project.account.repository.AccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

interface InsertOrUpdateAccountUseCase {
    suspend fun invoke(userName: String, password: String): Flow<Unit>
}

class InsertOrUpdateAccountUseCaseImpl(
    private val accountRepository: AccountRepository
) : InsertOrUpdateAccountUseCase {
    override suspend fun invoke(userName: String, password: String) =
        accountRepository.insertOrReplace(userName, password).flowOn(Dispatchers.IO)

}