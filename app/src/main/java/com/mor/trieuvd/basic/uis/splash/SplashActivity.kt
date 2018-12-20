package com.mor.trieuvd.basic.uis.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.interfaces.DraweeController
import com.mor.trieuvd.basic.R
import com.mor.trieuvd.basic.uis.termofuse.TermOfUseActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //load gif
        var controller : DraweeController = Fresco.newDraweeControllerBuilder()
            .setUri("https://i.imgur.com/qKmIi5r.gif")
            .setAutoPlayAnimations(true)
            .build()
        sdvGif.controller = controller
        //chuyen activity
        var thread = Thread(Runnable {
            Thread.sleep(5000)
            var intent = Intent(this, TermOfUseActivity::class.java)
            startActivity(intent)
            finish()
        })
        thread.start()
    }

}
