package com.mor.trieuvd.basic.uis.main

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Callback

import com.mor.trieuvd.basic.R
import com.mor.trieuvd.basic.model.User
import com.mor.trieuvd.basic.rest.APIs
import com.mor.trieuvd.basic.rest.RestClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customToolbar()
        getData()

    }

    private fun customToolbar() {
        setSupportActionBar(toobar)
        val actionBar = supportActionBar
        actionBar?.let {
            it.title = getString(R.string.title_home)
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_back)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun getData() {
            val call = RestClient.restClient.create(APIs::class.java).getUser
            call.enqueue(object : Callback<User> {
                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.e("CHECKDATA", "that bai" + t.message + " " + t.cause)
                }
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    Log.e("CHECKDATA", "thanh cong")
                    user = response.body()
                    initUI()
                }
            })
    }


    private fun initUI() {
        //set avatar
        sdvAvatar.setImageURI(Uri.parse(user?.avatarUrl), this)
        tvName.text = user?.name
        tvType.text = user?.type
        tvLocation.text = user?.location
        tvIndexRepos.text = user?.publicRepos.toString()
        tvIndexGithub.text = user?.publicGists.toString()
        tvIndexFllower.text = user?.followers.toString()
        tvIndexFllowing.text = user?.following.toString()

    }
}
