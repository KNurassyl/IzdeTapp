package com.example.izdetapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.example.izdetapp.databinding.ActivityMainBinding
import com.example.izdetapp.databinding.FragmentCreateBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class CreateFragment : Fragment() {
    private lateinit var binding: FragmentCreateBinding

    private val viewModel: CreateViewModel by viewModels()

    private val imageLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->
        if(result.resultCode == AppCompatActivity.RESULT_OK) {
            val uri = result?.data?.data ?: return@registerForActivityResult
            viewModel.onImageResult(uri)
        } else {
            Toast.makeText(activity, "Canceled", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCreateBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonChooseImage.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                imageLauncher.launch(it)
            }
        }


        binding.buttonUpload.setOnClickListener {
            viewModel.onClickButtonUpload("1")

            viewModel.isUploaded.observe(viewLifecycleOwner) { isUploadedLocal ->
                if (isUploadedLocal) {
                    Toast.makeText(activity, "Upload successful", Toast.LENGTH_SHORT).show()
                    binding.progressBar.progress = 1
                } else {
                    Toast.makeText(activity, "Error on upload", Toast.LENGTH_SHORT).show()
                }
            }
            viewModel.currentFile.observe(viewLifecycleOwner) {
                binding.imageView.setImageURI(it)
            }
        }
    }
}