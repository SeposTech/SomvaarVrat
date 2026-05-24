package com.spiritual.somvaarvrat.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SomvaarVartApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}