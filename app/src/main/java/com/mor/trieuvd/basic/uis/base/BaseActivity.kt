package com.mor.trieuvd.basic.uis.base

import androidx.appcompat.app.AppCompatActivity
import com.mor.trieuvd.basic.R
import kotlinx.android.synthetic.main.activity_main.*

abstract class BaseActivity : AppCompatActivity() {
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun customToolbar() {
        setSupportActionBar(toobar)
        val actionBar = supportActionBar
        actionBar?.let {
            it.title = getString(R.string.title_home)
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_back)
        }
    }
}