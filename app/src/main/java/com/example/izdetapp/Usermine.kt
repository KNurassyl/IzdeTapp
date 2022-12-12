package com.example.izdetapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Usermine : Serializable {
    //declaration of user table columns
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var name: String? = null

    var email: String? = null

    var password: String? = null


}