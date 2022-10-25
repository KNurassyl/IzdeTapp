package com.example.izdetapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.izdetapp.R
import androidx.drawerlayout.widget.DrawerLayout
import androidx.core.view.GravityCompat

class Convert : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerlayout)
        findViewById<View>(R.id.menuImg).setOnClickListener { drawerLayout.openDrawer(GravityCompat.START) }
    }
}