package ru.spiridonov.repair

import android.app.Application
import android.content.Context

class RepairApp : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }


    companion object {
        lateinit var appContext: Context
    }
}