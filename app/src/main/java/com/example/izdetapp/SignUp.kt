package com.example.izdetapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class SignUp : AppCompatActivity() {


    private lateinit var edtName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnSignUp: Button
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef: DatabaseReference

    var isExist = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mAuth = FirebaseAuth.getInstance()
        edtName = findViewById(R.id.edt_name)
        edtEmail = findViewById(R.id.edt_email)
        edtPassword = findViewById(R.id.edt_password)
        mAuth = FirebaseAuth.getInstance()
        btnSignUp = findViewById(R.id.SignUp)



        btnSignUp.setOnClickListener {


            val name = edtName.text.toString()
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()
            signUp(name, email, password)


        }
    }



    private fun signUp(name:String, email: String, password: String) {
/*
        val userDetailsRepository = ViewModelProvider(this@SignUp)[LoginViewModel::class.java]
        userDetailsRepository.getGetAllData().observe(
            this
        ) { t ->

            for (i in t.indices) {



                    if (t[i].email?.equals(email)!!) {
                        isExist = true
                        break
                    }

                 else {
                    isExist = false
                    continue

                }
            }

            if (isExist) {
                Toast.makeText(
                    this@SignUp,
                    " User Already Registered !!! ",
                    Toast.LENGTH_LONG
                )
                    .show()

            } else {

                val user = User()

                val userDatabase = UserDatabase
                userDatabase.getDatabase(this@SignUp)?.daoAccess()?.insertUserData(user)
                Toast.makeText(
                    this@SignUp,
                    " User  Registered Successfully",
                    Toast.LENGTH_LONG
                )
                    .show()


            }
        }


 */

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    addUserToDatabase(name, email, mAuth.currentUser?.uid!!)
                    val intent = Intent(this@SignUp, MainActivity::class.java)
                    finish()
                    startActivity(intent)


                } else {
                    Toast.makeText(this@SignUp, "Error", Toast.LENGTH_SHORT).show()
                }
            }
    }
     private fun addUserToDatabase(name:String, email:String, uid:String){
            mDbRef = FirebaseDatabase.getInstance().getReference()

         mDbRef.child("user").child(uid).setValue(User(name, email, uid))
     }




}



