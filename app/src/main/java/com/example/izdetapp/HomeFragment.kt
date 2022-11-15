package com.example.izdetapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.izdetapp.adapter.PostAdapter
import com.example.izdetapp.databinding.ActivityMainBinding
import com.example.izdetapp.databinding.FragmentHomeBinding
import com.example.izdetapp.model.PostModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

lateinit var appCompatActivity: AppCompatActivity
/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    lateinit var adapter: PostAdapter
    lateinit var recyclerView: RecyclerView
    // TODO: Rename and change types of parameters
    /*private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        *//*
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.*//*

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/

    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentHomeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        binding = FragmentHomeBinding.inflate(layoutInflater)

        inital()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val recyclerView: RecyclerView = binding.rvPost
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun inital(){
        recyclerView = binding.rvPost
        adapter = PostAdapter()
        recyclerView.adapter = adapter

        adapter.setList(myPost())
    }

    fun myPost() : java.util.ArrayList<PostModel>{
        val postList = ArrayList<PostModel>()

        val user1 = PostModel(R.drawable.ic_baseline_person_24, "solomolo", "Tam tam!", R.drawable.home_default_image1)
        postList.add(user1)

        val user2 = PostModel(R.drawable.ic_baseline_person_24,"solomolo", "Tam tam!", R.drawable.home_default_image2)
        postList.add(user2)

        val user3 = PostModel(R.drawable.ic_baseline_person_24,"solomolo", "Tam tam!", R.drawable.home_default_image1)
        postList.add(user3)

        val user4 = PostModel(R.drawable.ic_baseline_person_24  ,"solomolo", "Tam tam!", R.drawable.home_default_image2)
        postList.add(user4)


        return postList
    }
}