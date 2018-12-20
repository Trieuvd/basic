package com.mor.trieuvd.basic.uis.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.mor.trieuvd.basic.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customToolbar()

    }
    private fun customToolbar() {
        setSupportActionBar(toobar)
        val actionBar = supportActionBar
        actionBar?.let {
            it.title = getString(R.string.title_home)
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_back)
        }
        //custom toolbar
        /*val actionBar = supportActionBar
        setSupportActionBar(toobar)
        toobar
        toobar.navigationIcon = ContextCompat.getDrawable(this,R.drawable.ic_back)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.title = "Home"*/
        //supportActionBar?
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
