package com.example.izdetapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.izdetapp.R
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.Shapeable
import java.util.concurrent.ThreadLocalRandom

class BasketAdapter(private val basketList : java.util.ArrayList<Baskets>) : RecyclerView.Adapter<BasketAdapter.BasketViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_post_layout, parent, false)
        return BasketAdapter.BasketViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        val curItem = basketList[position]

        holder.postImage.setImageResource(curItem.PostImage)
        holder.tvHeading.text = curItem.heading
    }


    override fun getItemCount(): Int {
        return basketList.size
    }

    class BasketViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)
    {
        val postImage : ShapeableImageView = itemView.findViewById(R.id.image_content)
        val tvHeading : TextView = itemView.findViewById(R.id.content)
    }


}