package com.ihateham.androidpractice.db.local

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors

class SQLiteRepository(private val sqliteHelper: SQLiteHelper, private val sqliteDao: SQLiteDao) {

    // SQLITE가 돌아갈 때 사용할 전용 dispatcher
    private val databaseDispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()

    // SQLITE 트랜잭션 관리
    suspend fun <T> runInTransaction(block: suspend () -> T): T {
        return withContext(databaseDispatcher) {
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

    suspend fun insert() {
        runInTransaction {
//            sqliteDao.insertDatum()
        }
    }

}