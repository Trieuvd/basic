package com.mor.trieuvd.basic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mor.trieuvd.basic.R
import com.mor.trieuvd.basic.model.Follower

class FollowersAdapter(private val context: Context, private val listFollowers: List<Follower>) :
    RecyclerView.Adapter<FollowersAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowersAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_follower, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FollowersAdapter.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return listFollowers.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
