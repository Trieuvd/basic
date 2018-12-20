package com.mor.trieuvd.basic.uis.widgets

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View

import android.widget.ScrollView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

import com.mor.trieuvd.basic.R
import com.mor.trieuvd.basic.Utils.TermBus
import com.mor.trieuvd.basic.Utils.Utils
import kotlinx.android.synthetic.main.dialog_term.*
import org.greenrobot.eventbus.EventBus

class TermDialog(context: Context) : Dialog(context), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.tvAgree -> {
                dismiss()
                EventBus.getDefault().post(TermBus(true))
            }
        }
    }
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_term)
        //set full screen dialog
        var window = window
        window.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT)

        tvAgree.isEnabled = false
        svContentTerm.viewTreeObserver.addOnScrollChangedListener {
            if (svContentTerm.getChildAt(0).bottom
                <= (svContentTerm.height + svContentTerm.scrollY)) {
                tvAgree.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary))
                tvAgree.isEnabled = true
            }
        }
        tvAgree.setOnClickListener (this)
    }





}
