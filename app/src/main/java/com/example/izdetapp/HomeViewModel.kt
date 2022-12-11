package com.example.izdetapp

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.izdetapp.adapter.PostAdapter
import com.example.izdetapp.adapter.Posts
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class HomeViewModel : ViewModel() {
    private lateinit var adapter: PostAdapter
    private lateinit var recyclerView: RecyclerView
    var postsArrayList: java.util.ArrayList<Posts>? = null


    private var imageId: Array<Int>? = null
    private var heading: Array<String>? = null
    private var posts: Array<String>? = null

    fun dataInitialize(context: Context) {

        postsArrayList = arrayListOf<Posts>()

        imageId = arrayOf(
            R.drawable. a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
        )

        heading = arrayOf(
            context.getString(R.string.head_1),
            context.getString(R.string.head_2),
            context.getString(R.string.head_3),
            context.getString(R.string.head_4),
            context.getString(R.string.head_5),
            context.getString(R.string.head_6),
            context.getString(R.string.head_7),
            context.getString(R.string.head_8),
            context.getString(R.string.head_9),
            context.getString(R.string.head_10),
        )

        posts = arrayOf(
            context.getString(R.string.news_a),
            context.getString(R.string.news_b),
            context.getString(R.string.news_c),
            context.getString(R.string.news_d),
            context.getString(R.string.news_e),
            context.getString(R.string.news_f),
            context.getString(R.string.news_g),
            context.getString(R.string.news_h),
            context.getString(R.string.news_i),
            context.getString(R.string.news_j),
        )

        for (i in imageId!!.indices){
            val post = Posts(imageId!![i], heading!![i])
            postsArrayList?.add(post)
        }
    }
}
