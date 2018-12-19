package com.mor.trieuvd.basic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class demo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dialog = TermDialog(this)
    }
}
