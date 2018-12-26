package com.mor.trieuvd.basic.rest

import com.mor.trieuvd.basic.model.User
import retrofit2.Call
import retrofit2.http.GET

interface APIs {
    @get:GET("octocat")
    val getUser: Call<User>

    @get:GET("octocat/followers")
    val getFollowers: Call<List<User>>
}