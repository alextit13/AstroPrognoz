package com.astrology.astroprognoz.view.base

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        @JvmStatic
        var instance: App? = null
    }
}