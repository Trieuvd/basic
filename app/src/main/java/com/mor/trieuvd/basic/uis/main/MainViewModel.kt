package com.mor.trieuvd.basic.uis.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mor.trieuvd.basic.model.User
import com.mor.trieuvd.basic.rest.APIs
import com.mor.trieuvd.basic.rest.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private lateinit var user : MutableLiveData<User>

    fun getUser() : LiveData<User> {
        if (!::user.isInitialized) {
            user = MutableLiveData()
            loadUser()
        }
        return user
    }

    private fun loadUser() {
        val call = RestClient.restClient.create(APIs::class.java).getUser
        call.enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                user.value = response.body()
            }
        })
    }
}
