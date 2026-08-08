package com.spiritual.somvaarvrat.di

import android.app.Application
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.spiritual.somvaarvrat.BuildConfig
import com.spiritual.somvaarvrat.utils.AnalyticsHelper
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SomvaarVartApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AnalyticsHelper.init(this)
        // Disable Crashlytics in debug builds to avoid polluting crash reports
        FirebaseCrashlytics.getInstance().isCrashlyticsCollectionEnabled = !BuildConfig.DEBUG
    }
}