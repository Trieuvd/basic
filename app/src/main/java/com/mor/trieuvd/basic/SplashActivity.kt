package com.mor.trieuvd.basic

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.interfaces.DraweeController
import com.facebook.drawee.view.SimpleDraweeView
import kotlin.concurrent.thread

class SplashActivity : AppCompatActivity() {

    private lateinit var draweeView: SimpleDraweeView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        setContentView(R.layout.activity_splash)
        initUI()
        main()
    }

    private fun initUI() {
        draweeView = findViewById(R.id.sdv_gif)
    }

    private fun main() {
        //load gif
        var controller : DraweeController = Fresco.newDraweeControllerBuilder()
            .setUri("https://i.imgur.com/qKmIi5r.gif")
            .setAutoPlayAnimations(true)
            .build()
        draweeView.setController(controller)
        //chuyen activity
        var thread : Thread = Thread(Runnable {
            Thread.sleep(5000)
            var intent : Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
        thread.start()
    }
}
