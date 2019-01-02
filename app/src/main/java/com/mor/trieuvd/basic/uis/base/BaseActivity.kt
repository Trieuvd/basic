package com.mor.trieuvd.basic.uis.base

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.mor.trieuvd.basic.R
import kotlinx.android.synthetic.main.activity_main.*

abstract class BaseActivity : AppCompatActivity() {

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun customToolbar() : ActionBar? {
        setSupportActionBar(toobar)
        val actionBar = supportActionBar
        actionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_back)
        }
        return actionBar
    }
}