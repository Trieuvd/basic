package com.mor.trieuvd.basic.uis.followers

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mor.trieuvd.basic.model.User
import com.mor.trieuvd.basic.rest.APIs
import com.mor.trieuvd.basic.rest.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowersViewModel : ViewModel() {
    private lateinit var followers: MutableLiveData<List<User>>
    private val TAG: String = "CHECK_DATA_FOLLOWERS"

    fun getFollowers(): LiveData<List<User>> {
        if (!::followers.isInitialized) {
            followers = MutableLiveData()
            loadFollowers()
        }
        return followers
    }

    private fun loadFollowers() {
        val call = RestClient.restClient.create(APIs::class.java).getFollowers
        call.enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e(TAG, "That bai: " + t.cause + ":" + t.message)
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                Log.e(TAG, "thanh cong")
                followers.value = response.body()
            }


        })
    }
}