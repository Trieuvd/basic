package com.mor.trieuvd.basic

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private lateinit var cb_agree : CheckBox
    private lateinit var cl_agree : ConstraintLayout
    private lateinit var btn_enter : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        main()
    }

    private fun initUI() {
        cb_agree = findViewById(R.id.cb_agree)
        cl_agree = findViewById(R.id.cl_agree)
        btn_enter = findViewById(R.id.btn_enter)
    }

    private fun main() {
        cl_agree.setOnClickListener {
            var dialog = TermDialog(this)
            dialog.show()
        }
    }
}
