package com.example.izdetapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.izdetapp.R.id.editCPassword
import com.example.izdetapp.R.id.editUsername

class RegisterActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val btnRegister: Button = findViewById(R.id.btnRegister)

        val editUsername: EditText = findViewById(R.id.editUsername)
        val editCPassword: EditText = findViewById(R.id.editCPassword)
        val editPassword: EditText = findViewById(R.id.editPassword)
        val editEmail: EditText = findViewById(R.id.editEmail)

        val tvLogin: TextView = findViewById(R.id.tvLogin)

        btnRegister.setOnClickListener{

            if(editUsername.text.trim().isNotEmpty() && editEmail.text.trim().isNotEmpty() && editCPassword.text.trim().isNotEmpty() && editPassword.text.trim().isNotEmpty()){
                Toast.makeText(this, "Input provided", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this, "Input required", Toast.LENGTH_LONG).show()
            }

        }

        tvLogin.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}
