package com.Ihateham.androidpractice

import android.app.Application
import com.Ihateham.androidpractice.db.local.SQLiteHelper

class MyApplication : Application() {
    val sqlite: SQLiteHelper by lazy { SQLiteHelper.getInstance(this) }
    override fun onCreate() {
        super.onCreate()
    }
}