package com.Ihateham.androidpractice.db.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors

class SQLiteHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    private val databaseDispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()

    companion object {
        const val DATABASE_NAME = ""
        const val DATABASE_VERSION = 0
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

    suspend fun <T> runInTransaction(block: suspend () -> T): T {
        return withContext(databaseDispatcher) {
            writableDatabase.beginTransaction()
            try {
                val result = block()
                writableDatabase.setTransactionSuccessful()
                result
            } finally {
                writableDatabase.endTransaction()
            }
        }
    }
}