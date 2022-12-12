package com.example.izdetapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Accounts::class], version = 1)
abstract class AccountsDatabase : RoomDatabase() {
    abstract fun accountsDao(): AccountsDao
}
