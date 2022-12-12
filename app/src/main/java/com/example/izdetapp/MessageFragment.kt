package com.example.izdetapp



import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*






class MessageFragment : Fragment() {

    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userList: ArrayList<User>
    private lateinit var adapter: UserAdapter
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef: DatabaseReference



    override fun onCreateView(


        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
        mDbRef = FirebaseDatabase.getInstance().reference
        userList = ArrayList()
        adapter = UserAdapter(this, userList)
        userRecyclerView = view.findViewById(R.id.userRecyclerView)

        userRecyclerView.layoutManager = LinearLayoutManager(activity)
        userRecyclerView.adapter = adapter

        mDbRef.child("user").addValueEventListener(object : ValueEventListener {

       override fun onDataChange(snapshot: DataSnapshot) {
              userList.clear()
             for (postSnapshot in snapshot.children) {
                    val currentUser = postSnapshot.getValue(User::class.java)

                    if (mAuth.currentUser?.uid != currentUser?.uid) {
                       userList.add(currentUser!!)
                    }


                }
                adapter.notifyDataSetChanged()
            }

           override fun onCancelled(error: DatabaseError) {

          }


       })
    }

}





