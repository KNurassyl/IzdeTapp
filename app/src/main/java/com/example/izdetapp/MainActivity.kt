package com.example.izdetapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.service)

        val lost_found : ImageView = findViewById(R.id.lost_found)
        val sell_buy : ImageView = findViewById(R.id.sell_buy)
        val appartment : ImageView = findViewById(R.id.appa)

        lost_found.setImageResource(R.drawable.lost_found)
        sell_buy.setImageResource(R.drawable.sell_buy)
        appartment.setImageResource(R.drawable.appartment)


//        sell_buy.contentDescription = sell_buy.toString()
//        appartment.contentDescription = appartment.toString()


    }


}