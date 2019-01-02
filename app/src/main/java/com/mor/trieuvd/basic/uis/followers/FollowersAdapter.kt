package com.mor.trieuvd.basic.uis.followers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mor.trieuvd.basic.R
import com.mor.trieuvd.basic.model.User
import kotlinx.android.synthetic.main.item_follower.view.*

class FollowersAdapter(private val context: Context, private val listFollowers: MutableList<User>) :
    RecyclerView.Adapter<FollowersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_follower, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listFollowers[position])
        holder.llDelFollower.setOnClickListener {
            listFollowers.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return listFollowers.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val sdvAvatar = itemView.sdvAvatar
        private val tvLogin = itemView.tvLogin
        private val tvNodeID = itemView.tvNodeID
        val llDelFollower = itemView.llDelFollower!!

        fun bind(user: User) {
            user?.let {
                sdvAvatar.setImageURI(it.avatarUrl)
                tvLogin.text = it.login
                tvNodeID.text = it.nodeId
            }
        }
    }
}
