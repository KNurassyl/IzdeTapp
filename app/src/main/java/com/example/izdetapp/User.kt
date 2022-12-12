package com.example.izdetapp

import android.annotation.SuppressLint
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity
class User: Serializable{
    @SuppressLint("KotlinNullnessAnnotation")
    @PrimaryKey(autoGenerate = false)
    @NonNull
    var name: String? = null
    var email: String? = null
    var uid: String? = null


    constructor(){}
    constructor(name: String?, email: String?, uid: String?){
        this.name = name
        this.email = email
        this.uid = uid
    }

}
