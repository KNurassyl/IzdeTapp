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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [CreateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentCreateBinding
    private var imageReference = Firebase.storage.reference
    private var currentFile: Uri? = null

    private val viewModel: CreateViewModel by viewModels()

    private val imageLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
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
            uploadImageToStorage("1")
        }
    }

    private fun uploadImageToStorage(filename: String) {
        try {
            currentFile?.let {
                imageReference.child("images/$filename").putFile(it).addOnSuccessListener {
                    Toast.makeText(activity, "Upload successful", Toast.LENGTH_SHORT).show()
                    binding.progressBar.progress = 1
                } .addOnFailureListener {
                    Toast.makeText(activity, "Error on upload", Toast.LENGTH_SHORT).show()
                }
            }
        }catch (e : Exception) {
            Toast.makeText(activity, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}