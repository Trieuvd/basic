package com.mor.trieuvd.basic.uis.followers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mor.trieuvd.basic.model.Follower

class FollowersViewModel : ViewModel() {
    private lateinit var followers: MutableLiveData<List<Follower>>

    fun getFollowers() : LiveData<List<Follower>> {
        if (!::followers.isInitialized) {
            followers = MutableLiveData()
            loadFollowers()
        }
        return followers
    }

    private fun loadFollowers() {

    }
}