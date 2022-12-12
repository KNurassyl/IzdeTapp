package com.example.izdetapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignUp: Button

    private lateinit var mAuth: FirebaseAuth
    var isExist = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        edtEmail = findViewById(R.id.edt_email)
        edtPassword = findViewById(R.id.edt_password)
        btnLogin = findViewById(R.id.btn_Login)
        btnSignUp = findViewById(R.id.SignUp)

        mAuth = FirebaseAuth.getInstance()

        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()
            login(email, password)


        }


    }

    private fun login(email: String, password: String) {
/*
        val userDetailsRepository = ViewModelProvider(this).get(LoginViewModel::class.java)

        userDetailsRepository.getGetAllData().observe(
            this
        ) { t ->

            for (i in t.indices) {

                if (t[i].email?.equals(email)!!) {

                    val intent = Intent(this@Login, MainActivity::class.java)
                        .putExtra("UserDetials", t[i])

                    startActivity(intent)

                } else {
                    Toast.makeText(
                        this@Login,
                        " Password is Incorrect ",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }
                isExist = true
                break
            }


            if (isExist) {

            } else {

                Toast.makeText(this@Login, " User Not Registered ", Toast.LENGTH_LONG)
                    .show()
            }
        }


 */


        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
//code for logging
                    val intent = Intent(this@Login, MainActivity::class.java)
                    finish()
                    startActivity(intent)

                } else {
                    Toast.makeText(this@Login, "User doesn't exist", Toast.LENGTH_SHORT).show()
                }
            }
    }


    }


