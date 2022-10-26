package com.example.izdetapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.magzhan)
        /* supportActionBar?.hide()

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerlayout)
        findViewById<View>(R.id.menuImg).setOnClickListener { drawerLayout.openDrawer(GravityCompat.START) }

        val navigationView = findViewById<NavigationView>(R.id.navView)
        navigationView.itemIconTintList = null */


        val btnLogin: Button = findViewById(R.id.btnLogin)
        val edUsername: EditText = findViewById(R.id.edUsername)
        val edPassword: EditText = findViewById(R.id.edPassword)
        val tvRegister: TextView = findViewById(R.id.tvRegister)

        btnLogin.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show()
            if (edUsername.text.trim().isNotEmpty() && edPassword.text.trim().isNotEmpty()) {
                Toast.makeText(this, "Input provided", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Input required", Toast.LENGTH_LONG).show()
            }

        }
       // tvRegister.setOnClickListener {
        //    val intent = Intent(this, RegisterActivity::class.java)
        //    startActivity(intent)

        }
    }

    



