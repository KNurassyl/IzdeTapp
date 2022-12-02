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

    private val _imageReference = MutableLiveData(imgReference)
    val imageReference: LiveData<StorageReference>
        get() = _imageReference
    private val _currentFile = MutableLiveData<Uri>()
    val currentFile: LiveData<Uri>
        get() = _currentFile

    /* private val imageLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->
        if(result.resultCode == AppCompatActivity.RESULT_OK) {
            result?.data?.data?.let {
                currentFile = it
                val mImageView: ImageView = requireActivity().findViewById(R.id.image_view)
                mImageView.setImageURI(it)
            }
        }
        else {
            Toast.makeText(activity, "Canceled", Toast.LENGTH_SHORT).show()
        }
    }

    fun uploadImageToStorage(filename: String) {
        try {
            currentFile?.let {
                imgReference.child("images/$filename").putFile(it).addOnSuccessListener {
                    Toast.makeText(activity, "Upload successful", Toast.LENGTH_SHORT).show()
                    binding.progressBar.progress = 1
                } .addOnFailureListener {
                    Toast.makeText(activity, "Error on upload", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e : Exception) {
            Toast.makeText(activity, e.toString(), Toast.LENGTH_SHORT).show()
        }
    } */

}
