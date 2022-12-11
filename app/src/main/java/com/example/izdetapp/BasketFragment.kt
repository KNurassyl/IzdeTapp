package com.example.izdetapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.izdetapp.adapter.BasketAdapter
import com.example.izdetapp.adapter.Baskets
import com.example.izdetapp.adapter.PostAdapter
import com.example.izdetapp.adapter.Posts

class BasketFragment : Fragment() {

    private lateinit var adapter: BasketAdapter
    private lateinit var recyclerView: RecyclerView
    private val viewModel: BasketViewModel by viewModels()

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
        viewModel.dataInitialize(requireContext())
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_post2)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = BasketAdapter(viewModel.postsArrayList!!)
        recyclerView.adapter = adapter
    }
}