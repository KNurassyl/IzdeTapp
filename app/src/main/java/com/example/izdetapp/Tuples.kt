package com.example.izdetapp

data class AccountSignInTuple (
    val id: Long,
     val password:String
)
data class AccountUpdateUsernameTuple(
    val id: Long,
    val password:String
)