package com.example.shared.ui.model

import android.app.Application
import com.example.shared.Preferences

class DBHelperApplication: Application() {
    companion object{
        lateinit var dataSource : IDBHelper
        lateinit var preferences: Preferences
    }

    override fun onCreate() {
        super.onCreate()
        dataSource = DBHelper(applicationContext, null)
        preferences = Preferences(applicationContext)
    }
}