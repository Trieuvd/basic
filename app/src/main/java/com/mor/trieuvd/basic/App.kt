package com.mor.trieuvd.basic

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}