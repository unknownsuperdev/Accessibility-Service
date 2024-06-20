package com.project.account.database.core.dao.accountsDao

import com.project.account.model.Account
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = AccountEntity.TABLE_NAME)
data class AccountEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "user_name") val userName: String,
    @ColumnInfo(name = "password") val password: String,
) {
    companion object {
        const val TABLE_NAME = "account"
    }
}

fun AccountEntity.toInstagramAccount() = Account(
    id = id,
    userName = userName,
    password = password
)

fun Account.toInstagramAccountEntity() = AccountEntity(
    id = id,
    userName = userName,
    password = password
)
