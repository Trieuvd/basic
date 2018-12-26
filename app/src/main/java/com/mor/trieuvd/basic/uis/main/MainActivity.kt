package com.mor.trieuvd.basic.uis.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import retrofit2.Callback

import com.mor.trieuvd.basic.R
import com.mor.trieuvd.basic.model.User
import com.mor.trieuvd.basic.rest.APIs
import com.mor.trieuvd.basic.rest.RestClient
import com.mor.trieuvd.basic.uis.base.BaseActivity
import com.mor.trieuvd.basic.uis.followers.FollowersActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : BaseActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customToolbar()

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getUser().observe(this, Observer<User> { user ->
            initUI(user)
        })
    }

    private fun initUI(user: User?) {
        //set avatar
        Log.e("TEST_NULL", "data not exist")
        user?.let {
            Log.e("TEST_NULL", "data exist")
            sdvAvatar.setImageURI(Uri.parse(it.avatarUrl), this)
            tvName.text = it.name
            tvType.text = it.type
            tvLocation.text = it.location
            tvIndexRepos.text = it.publicRepos.toString()
            tvIndexGithub.text = it.publicGists.toString()
            tvIndexFllower.text = it.followers.toString()
            tvIndexFllowing.text = it.following.toString()
        }
        btShowAllFollowers.setOnClickListener {
            intent = Intent(this, FollowersActivity::class.java)
            startActivity(intent)
        }


    }
}
