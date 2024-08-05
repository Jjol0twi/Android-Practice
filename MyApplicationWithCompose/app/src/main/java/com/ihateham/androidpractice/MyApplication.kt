package com.ihateham.androidpractice

import android.app.Application

class MyApplication : Application() {
    val sqlite: SQLiteHelper by lazy { SQLiteHelper.getInstance(this) }
    override fun onCreate() {
        super.onCreate()
    }
}