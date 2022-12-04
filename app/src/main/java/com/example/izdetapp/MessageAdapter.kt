package com.example.izdetapp

import android.view.View
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.NonDisposableHandle.parent

class MessageAdapter(val context: Context, val messageList: ArrayList<Message>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val item_recieve = 1
    val item_sent = 2


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == 1){

            val view: View = LayoutInflater.from(context).inflate(R.layout.receive, parent, false )
            return ReceiveViewHolder(view)

        }
        else{

            val view: View = LayoutInflater.from(context).inflate(R.layout.sent, parent, false )
            return SentViewHolder(view)

        }



    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val currentMessage = messageList[position]

        if (holder.javaClass == SentViewHolder::class.java){
            val viewHolder = holder as SentViewHolder
            holder.sentMessage.text = currentMessage.message

        }
        else{
            val viewHolder = holder as ReceiveViewHolder
            holder.reciveMessage.text = currentMessage.message
        }
    }

    override fun getItemViewType(position: Int): Int {
        val currentMessage = messageList[position]

        if(FirebaseAuth.getInstance().currentUser?.uid.equals(currentMessage.senderId)){
            return item_sent
        }
        else{
            return item_recieve
        }
    }

    override fun getItemCount(): Int {

        return messageList.size

    }


    class SentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val sentMessage = itemView.findViewById<TextView>(R.id.txt_sent_message)

    }

    class ReceiveViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val reciveMessage = itemView.findViewById<TextView>(R.id.txt_receive_message)
    }
}