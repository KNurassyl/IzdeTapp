package com.example.izdetapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.izdetapp.adapter.Posts
import com.example.izdetapp.adapter.PostAdapter
import com.example.izdetapp.databinding.FragmentCreateBinding

class HomeFragment : Fragment() {

    private lateinit var adapter: PostAdapter
    private lateinit var recyclerView: RecyclerView

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.dataInitialize(requireContext())

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_post)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = PostAdapter(viewModel.postsArrayList!!)

        recyclerView.adapter = adapter

    }
}
