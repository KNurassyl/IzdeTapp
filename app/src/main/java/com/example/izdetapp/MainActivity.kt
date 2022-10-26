package com.example.izdetapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
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

//        val lost_found : ImageView = findViewById(R.id.lost_found)
//        val sell_buy : ImageView = findViewById(R.id.sell_buy)
//        val appartment : ImageView = findViewById(R.id.appa)
//
//        lost_found.setImageResource(R.drawable.lost_found)
//        sell_buy.setImageResource(R.drawable.sell_buy)
//        appartment.setImageResource(R.drawable.appartment)


    }

}