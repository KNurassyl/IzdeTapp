package com.example.izdetapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.izdetapp.adapter.BasketAdapter
import com.example.izdetapp.adapter.Baskets
import com.example.izdetapp.adapter.PostAdapter
import com.example.izdetapp.adapter.Posts

class BasketFragment : Fragment() {

    private lateinit var adapter: BasketAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var postsArraylist: java.util.ArrayList<Baskets>

    private lateinit var imageId: Array<Int>
    private lateinit var heading: Array<String>
    private lateinit var baskets: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basket, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_post2)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = BasketAdapter(postsArraylist)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize(){

        postsArraylist = arrayListOf<Baskets>()

        imageId = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,

        )

        heading = arrayOf(
            getString(R.string.head_1),
            getString(R.string.head_2),
            getString(R.string.head_3),
        )

        baskets = arrayOf(
            getString(R.string.news_a),
            getString(R.string.news_b),
            getString(R.string.news_c),
           )

        for (i in imageId.indices){
            val basket = Baskets(imageId[i], heading[i])
            postsArraylist.add(basket)
        }
    }
}