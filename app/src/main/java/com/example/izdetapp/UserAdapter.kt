package com.example.izdetapp
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class UserAdapter(val context: MessageFragment, val userList:ArrayList<User>): RecyclerView.Adapter<UserAdapter.UserViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder{
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.user_layout, parent, false )
        return UserViewHolder(view)

        }
    override fun onBindViewHolder(holder: UserViewHolder, position: Int){

        val currentUser = userList[position]
        holder.textName.text = currentUser.name

        holder.itemView.setOnClickListener{

            val intent = Intent(holder.itemView.context, ChatActivity::class.java)

            intent.putExtra("name", currentUser.name)
            intent.putExtra("uid", currentUser.uid)
            context.startActivity(intent)
        }
    }
    override fun getItemCount():Int{
        return userList.size
    }

    class UserViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val textName = itemView.findViewById<TextView>(R.id.txt_name)
    }





}