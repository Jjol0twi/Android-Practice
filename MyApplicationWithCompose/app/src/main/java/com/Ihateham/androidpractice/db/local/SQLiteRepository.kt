package com.Ihateham.androidpractice.db.local

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SQLiteRepository(private val sqliteHelper: SQLiteHelper, private val sqliteDao: SQLiteDao) {

    // SQLITE 트랜잭션 관리
    suspend fun <T> runInTransaction(block: suspend () -> T): T {
        return withContext(Dispatchers.IO) {
            val sqlite = sqliteHelper.writableDatabase
            sqlite.beginTransaction()
            try {
                val result = block()
                sqlite.setTransactionSuccessful()
                result
            } finally {
                sqlite.endTransaction()
            }
        }
    }

    suspend fun insert(){
        runInTransaction {

        }
    }

}