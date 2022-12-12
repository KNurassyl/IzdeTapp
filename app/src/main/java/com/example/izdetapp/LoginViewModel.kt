package com.example.izdetapp

import androidx.lifecycle.LiveData
import android.app.Application
import androidx.lifecycle.AndroidViewModel


class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: UserDetailsRepository
     private var getAllDatas: LiveData<List<User>>

init {

    repository = UserDetailsRepository(application)
    getAllDatas = repository.getAllData()!!
}

    fun insert(data: User) {
        repository.insertData(data)
    }
    fun getGetAllData(): LiveData<List<User>> {
        return getAllDatas
    }
}
