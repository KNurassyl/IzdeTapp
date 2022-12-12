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
/*

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_signup.*
import source.open.akash.roomdbkotlin.R
import source.open.akash.roomdbkotlin.db.UserDatabase
import source.open.akash.roomdbkotlin.modelorentity.User
import source.open.akash.roomdbkotlin.viewmodel.LoginViewModel
/**
 * Created by Akash Kumar on 4/17/2020.
 * https://github.com/eduxcellence
 * akkr2017@gmail.com
 */
class SignupActivity : AppCompatActivity() {
    /**
     * @param isExist  bool parameter for check existency of user or not in database
     */
    var isExist = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        //calling view mdioel object
        val userDetailsRepository = ViewModelProvider(this@SignupActivity).get(LoginViewModel::class.java)

        btn_login.setOnClickListener {
            val intent = Intent(this@SignupActivity, LoginActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

        btn_register.setOnClickListener {
            if (validation()) {
                userDetailsRepository.getGetAllData().observe(this, object : Observer<List<User>> {
                    override fun onChanged(t: List<User>) {
                        var userObject = t

                        for (i in userObject.indices) {


                            if (userObject[i].email?.equals(et_mobile_no.text.toString())!!) {
                                isExist = true
                                //Toast.makeText(this@SignupActivity," User Already Registered ", Toast.LENGTH_LONG).show()
                                break

                            } else {
                                isExist = false
                                continue

                            }
                        }

                        if (isExist) {
                            Toast.makeText(this@SignupActivity, " User Already Registered !!! ", Toast.LENGTH_LONG)
                                .show()

                        } else {

                            val user = User()
                          //  user.dob = et_dob.text.toString()
                            user.name = et_fullname.text.toString()
                            user.email = et_mobile_no.text.toString()
                            user.password = et_password.text.toString()
                            val userDatabase = UserDatabase
                            userDatabase.getDatabase(this@SignupActivity)?.daoAccess()?.insertUserData(user)
                            Toast.makeText(this@SignupActivity, " User  Registered Successfully", Toast.LENGTH_LONG)
                                .show()


                        }

                    }

                })
            }

        }


    }

    /**
     * Attempts to register in  the account specified by the registration form.
     * If there are form errors (invalid name, missing fields, etc.), the
     * errors are presented in form of toast and no actual login attempt is made.
     */
    private fun validation(): Boolean {
        if (et_fullname.text.isNullOrEmpty()) {
            Toast.makeText(this@SignupActivity, " Enter Full Name ", Toast.LENGTH_LONG).show()
            return false
        }

        if (et_mobile_no.text.isNullOrEmpty()) {
            Toast.makeText(this@SignupActivity, " Enter Mobile Number ", Toast.LENGTH_LONG).show()
            return false
        }
        if (et_mobile_no.text.toString().length != 10) {
            Toast.makeText(this@SignupActivity, " Enter 10 digit Mobile Number ", Toast.LENGTH_LONG).show()
            return false
        }
        if (et_password.text.isNullOrEmpty()) {
            Toast.makeText(this@SignupActivity, " Enter Password ", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

}

 */



