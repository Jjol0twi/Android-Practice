package com.ihateham.androidpractice.db.local

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import kotlinx.coroutines.asCoroutineDispatcher
import java.util.concurrent.Executors

class SQLiteHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    private val databaseDispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()

    companion object {
        const val DATABASE_NAME = "sqliteDatabase.db"
        const val DATABASE_VERSION = 1

        private var instance: SQLiteHelper? = null
        fun getInstance(context: Context): SQLiteHelper = instance ?: synchronized(this) {
            instance ?: SQLiteHelper(context).also { instance = it }
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        TODO("Not yet implemented")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    private fun createTable(){

    }

}