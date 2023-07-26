package com.example.dbadapter.model

import android.app.Application

class DBHelperApplication: Application() {
    companion object{
        lateinit var dataSource : IDBHelper
    }

    override fun onCreate() {
        super.onCreate()
        dataSource = DBHelper(applicationContext, null)
    }
}