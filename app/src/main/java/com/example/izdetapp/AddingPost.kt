package com.example.izdetapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.izdetapp.databinding.FragmentCreateBinding
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class AddingPost : AppCompatActivity() {
    private lateinit var binding: FragmentCreateBinding
    private var imageReference = Firebase.storage.reference

    private var currentFile: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonChooseImage.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                imageLauncher.launch(it)
            }
        }

        binding.buttonUpload.setOnClickListener {
            uploadImageToStorage("1")
        }
    }

    private val imageLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->
        if(result.resultCode == RESULT_OK) {
            result?.data?.data?.let {
                currentFile = it
                val mImageView: ImageView = findViewById(R.id.image_view)
                mImageView.setImageURI(it)
            }
        }
        else {
            Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show()
        }
    }

    private fun uploadImageToStorage(filename: String) {
        try {
            currentFile?.let {
                imageReference.child("images/$filename").putFile(it).addOnSuccessListener {
                    Toast.makeText(this, "Upload successful", Toast.LENGTH_SHORT).show()
                } .addOnFailureListener {
                    Toast.makeText(this, "Error on upload", Toast.LENGTH_SHORT).show()
                }
            }
        }catch (e : Exception) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}