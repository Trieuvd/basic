package com.mor.trieuvd.basic.uis.followers

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mor.trieuvd.basic.R
import com.mor.trieuvd.basic.model.User
import com.mor.trieuvd.basic.uis.base.BaseActivity
import kotlinx.android.synthetic.main.activity_followers.*

class FollowersActivity : BaseActivity() {

    private lateinit var viewModel: FollowersViewModel
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_followers)
        customToolbar()
        viewModel = ViewModelProviders.of(this).get(FollowersViewModel::class.java)
        viewModel.getFollowers().observe(this, Observer<List<User>> { followers ->
            followers?.let {
                val adapterFollowers = FollowersAdapter(this, it)
                rvFollowers.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(this@FollowersActivity)
                    adapter = adapterFollowers
                }
            }
        })
    }
}
