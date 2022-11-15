package com.example.izdetapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.izdetapp.model.PostModel
import com.example.izdetapp.R
import kotlinx.android.synthetic.main.item_post_layout.view.*

class PostAdapter: RecyclerView.Adapter<PostAdapter.PostViewHolder>(){

    private var postList = emptyList<PostModel>()

    class PostViewHolder(view : View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_post_layout, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.itemView.image_profile.setImageResource(postList[position].image_profile)
        holder.itemView.username.text = postList[position].username
        holder.itemView.content.text = postList[position].content
        holder.itemView.image_content.setImageResource(postList[position].image_content)
//        holder.itemView.image_content. = postList[position].content
//        holder.itemView.like.drawable() = postList[position].like
//        holder.itemView.message.drawable() = postList[position].message
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    fun setList(list : List<PostModel>){
        postList = list
        notifyDataSetChanged()
    }
}