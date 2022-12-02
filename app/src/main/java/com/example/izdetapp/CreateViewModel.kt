package com.example.izdetapp

import android.net.Uri
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import com.google.firebase.storage.ktx.storage

class CreateViewModel : ViewModel() {
    private val imgReference = Firebase.storage.reference

    private val _currentFile = MutableLiveData<Uri>()
    val currentFile: LiveData<Uri>
        get() = _currentFile

    private val _isUploaded = MutableLiveData<Boolean>()
    val isUploaded: LiveData<Boolean>
        get() = _isUploaded


    fun onClickButtonUpload(filename: String) {
        try {
            currentFile.value?.let {
                imgReference.child("images/$filename").putFile(it).addOnSuccessListener {
                    _isUploaded.value = true
                } .addOnFailureListener {
                    _isUploaded.value = false
                }
            }
        } catch (e : Exception) {
            _isUploaded.value = false
        }
    }

    fun onImageResult(uri: Uri) {
        _currentFile.value = uri
    }


}
