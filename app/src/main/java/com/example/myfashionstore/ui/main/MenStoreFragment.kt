package com.example.myfashionstore.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.drakeet.multitype.MultiTypeAdapter
import com.example.myfashionstore.R
import com.example.myfashionstore.StoreItem
import com.example.myfashionstore.StoreItemDelegate
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_men_storeragment.*
import java.util.*
import kotlin.collections.ArrayList

class MenStoreFragment : Fragment() {

    private val multiAdapter = MultiTypeAdapter()

    private val items=ArrayList<StoreItem>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_men_storeragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemsDelegate = StoreItemDelegate(requireContext())
        multiAdapter.register(itemsDelegate)

        items.clear()
        rvMen.setMultiRv(requireContext(),multiAdapter)
        FirebaseDatabase.getInstance().reference.child("Men")
            .addChildEventListener(object :ChildEventListener{
                override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                    val item = snapshot.getValue(StoreItem::class.java)!!
                    Log.i("data", item.toString());
                    items.add(item)
                    Log.i("date", items.size.toString())
                    multiAdapter.items=items
                    multiAdapter.notifyDataSetChanged()
                }

                override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {

                }

                override fun onChildRemoved(snapshot: DataSnapshot) {

                }

                override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {

                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
    }
}