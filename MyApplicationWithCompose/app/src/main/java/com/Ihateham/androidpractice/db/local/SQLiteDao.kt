package com.Ihateham.androidpractice.db.local

import android.content.ContentValues

interface SQLiteDao {
    suspend fun insertData(tableName: String)
    suspend fun readAllData(tableName: String)
    suspend fun readData(tableName: String)
}

class SQLiteDaoImpl(private val dbHelper: SQLiteHelper) : SQLiteDao {
    override suspend fun insertData(tableName: String) {
        dbHelper.runInTransaction {
            val cv = ContentValues()
            dbHelper.writableDatabase.insert(tableName, null, cv)
        }
    }

    override suspend fun readAllData(tableName: String) {
        return dbHelper.runInTransaction {
            val cursor = dbHelper.readableDatabase.rawQuery("SELECT * FROM $tableName", null)
            val data: MutableList<String> = mutableListOf()
            if (cursor.moveToFirst()) {
                do {
                    for (i in cursor.columnNames) {
                        val columnIndex = cursor.getColumnIndex(i)
                        val columnValue = cursor.getString(columnIndex)
                        data.add(columnValue)
                    }
                } while (
                    cursor.moveToNext()
                )
            }
            cursor.close()
            data
        }
    }

    override suspend fun readData(tableName: String) {
        TODO("Not yet implemented")
    }
}