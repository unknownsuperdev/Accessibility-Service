package com.project.account.database.core.dao.accountsDao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDao {
    @Query("SELECT * FROM ${AccountEntity.TABLE_NAME}")
    fun getAll(): Flow<List<AccountEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(obj: AccountEntity)

    @Delete
    suspend fun delete(obj: AccountEntity)
}