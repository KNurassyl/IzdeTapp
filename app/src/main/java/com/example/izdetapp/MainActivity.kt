package com.example.izdetapp


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

import com.example.izdetapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.database.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAuth:FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //fetching user details from intent object
        val UserDetials = intent.getSerializableExtra("UserDetials") as? User




        val bottomNavigationView: BottomNavigationView = binding.bottomNavigationView
        val navController = findNavController(R.id.fragmentContainerView5)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.basketFragment,
                R.id.createFragment,
                R.id.messageFragment,
                R.id.profileFragment
            )
        )





        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)




    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logout){
            mAuth.signOut()
            val intent = Intent(this@MainActivity, Login::class.java)
            finish()
            startActivity(intent)
            return true
        }
        return true
    }
}
/*import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import source.open.akash.roomdbkotlin.R
import source.open.akash.roomdbkotlin.modelorentity.User
/**
 * Created by Akash Kumar on 4/17/2020.
 * https://github.com/eduxcellence
 * akkr2017@gmail.com
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //fetching user details from intent object
        val UserDetials = intent.getSerializableExtra("UserDetials") as? User

        //show user details in the mainactivity screen ui
        tv_fullname.text = UserDetials?.name
        tv_mobileno.text = UserDetials?.email

    }
}


 */

