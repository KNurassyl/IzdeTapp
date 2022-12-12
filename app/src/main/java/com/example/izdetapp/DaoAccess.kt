package com.example.izdetapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query



@Dao
interface DaoAccess {


    @Insert
    fun insertUserData(user: User)  //   query is written above for insert all details of user

    @Query("select * from User")
    fun getDetails(): LiveData<List<User>> //   query is written above for fetching all details of user

    @Query("DELETE FROM User WHERE uid = :id")
    fun deleteByUserId(id: String)   //  do it by your own for practise  query is written above
}