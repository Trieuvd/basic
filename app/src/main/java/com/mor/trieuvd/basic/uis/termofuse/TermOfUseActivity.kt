package com.mor.trieuvd.basic.uis.termofuse

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mor.trieuvd.basic.R
import com.mor.trieuvd.basic.Utils.TermBus
import com.mor.trieuvd.basic.uis.widgets.TermDialog
import com.mor.trieuvd.basic.uis.main.MainActivity
import kotlinx.android.synthetic.main.activity_term_of_use.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.ThreadMode
import org.greenrobot.eventbus.Subscribe



class TermOfUseActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.clAgree -> {
                var dialog = TermDialog(this)
                dialog.show()
            }
            R.id.btnEnter -> {
                if (!cbAgree.isChecked) {
                    Toast.makeText(this, "please check team", Toast.LENGTH_SHORT).show()
                } else {
                    intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_term_of_use)
        //set Event
        clAgree.setOnClickListener(this)
        btnEnter.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Suppress("UnUse")
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: TermBus) {
        event?.let {
            cbAgree.isChecked = event.checked
        }
    }


}
