package com.example.izdetapp

import androidx.room.*

@Dao
interface AccountsDao {

    @Insert
    suspend fun insertBook(accounts: Accounts)

    @Query("SELECT * FROM accounts_table")
    fun getAllBooks(): List<Accounts>

    @Update
    suspend fun updateBook(accounts: Accounts)

    @Delete
    suspend fun deleteBook(accounts: Accounts)

}