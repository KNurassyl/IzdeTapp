package com.example.izdetapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts_table")
data class Accounts(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    var name: String,

    @ColumnInfo(name = "published_user")
    var user: String
)
