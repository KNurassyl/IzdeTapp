package com.example.izdetapp

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.izdetapp.adapter.Baskets

class BasketViewModel : ViewModel() {
    var postsArrayList: java.util.ArrayList<Baskets>? = null

    private var imageId: Array<Int>? = null
    private var heading: Array<String>? = null
    private var baskets: Array<String>? = null

    fun dataInitialize(context: Context){

        postsArrayList = arrayListOf<Baskets>()

        imageId = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,

            )

        heading = arrayOf(
            context.getString(R.string.head_1),
            context.getString(R.string.head_2),
            context.getString(R.string.head_3),
        )

        baskets = arrayOf(
            context.getString(R.string.news_a),
            context.getString(R.string.news_b),
            context.getString(R.string.news_c),
        )

        for (i in imageId!!.indices){
            val basket = Baskets(imageId!![i], heading!![i])
            postsArrayList?.add(basket)
        }
    }
}