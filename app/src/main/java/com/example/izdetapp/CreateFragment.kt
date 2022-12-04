package com.example.izdetapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.izdetapp.databinding.FragmentCreateBinding
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CreateFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentCreateBinding
    private var imageReference = Firebase.storage.reference
    private lateinit var title: EditText


    private var currentFile: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


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
        // Inflate the layout for
        // this fragment
        binding = FragmentCreateBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title = requireView().findViewById(R.id.edit_text_file_name)
        binding.buttonChooseImage.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                imageLauncher.launch(it)
            }
        }

        binding.buttonUpload.setOnClickListener {
            uploadImageToStorage("1")
            title.addTextChangedListener(textWatcher)
        }

    }
    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val name = title.text.toString().trim { it <= ' ' }
            binding.buttonUpload.isEnabled = name.isNotEmpty();
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