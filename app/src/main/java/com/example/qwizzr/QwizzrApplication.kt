package com.example.qwizzr

import android.app.Application
import timber.log.Timber

class QwizzrApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}