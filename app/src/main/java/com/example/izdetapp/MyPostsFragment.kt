package com.example.izdetapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.izdetapp.adapter.PostAdapter
import com.example.izdetapp.databinding.FragmentMyPostsBinding
import com.example.izdetapp.model.PostModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MyPostsFragment : Fragment() {
    lateinit var binding : FragmentMyPostsBinding
    lateinit var adapter: PostAdapter
    lateinit var recyclerView: RecyclerView

    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentMyPostsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        binding = FragmentMyPostsBinding.inflate(layoutInflater)

        inital()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMyPostsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val recyclerView: RecyclerView = binding.recycleViewMyPosts
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyPostsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun inital(){
        recyclerView = binding.recycleViewMyPosts
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
