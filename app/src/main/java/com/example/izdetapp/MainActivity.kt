package com.example.izdetapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerlayout)
        findViewById<View>(R.id.menuImg).setOnClickListener { drawerLayout.openDrawer(GravityCompat.START) }

        val navigationView = findViewById<NavigationView>(R.id.navView)
        navigationView.itemIconTintList = null
    }

}