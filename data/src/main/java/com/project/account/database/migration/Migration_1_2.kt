package com.project.account.database.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

private const val VERSION_FROM = 1
private const val VERSION_TO = 2

class Migration_1_2 : Migration(VERSION_FROM, VERSION_TO) {

    override fun migrate(database: SupportSQLiteDatabase) {
            // write here you migration
    }
}