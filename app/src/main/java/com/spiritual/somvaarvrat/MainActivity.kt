package com.spiritual.somvaarvrat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.spiritual.somvaarvrat.presentation.navigation.Navigation

class MainActivity : ComponentActivity() {
    lateinit var appUpdateManager: AppUpdateManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appUpdateManager = AppUpdateManagerFactory.create(this)
        setContent {
            Navigation(appUpdateManager)
        }
    }
}

