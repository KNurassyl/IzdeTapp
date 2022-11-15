package com.example.recylerviewyt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.izdetapp.R
import com.example.izdetapp.adapter.Posts
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.Shapeable
import java.util.concurrent.ThreadLocalRandom

class PostAdapter(private val postList : java.util.ArrayList<Posts>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_post_layout, parent, false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val curItem = postList[position]

        holder.postImage.setImageResource(curItem.PostImage)
        holder.tvHeading.text = curItem.heading
    }


    override fun getItemCount(): Int {
        return postList.size
    }

    class PostViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)
    {
        val postImage : ShapeableImageView = itemView.findViewById(R.id.image_content)
        val tvHeading : TextView = itemView.findViewById(R.id.content)
    }
}