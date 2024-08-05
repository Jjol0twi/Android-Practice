package com.ihateham.androidpractice.db.local

import android.content.ContentValues
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface SQLiteDao {
    suspend fun insertDatum(tableName: String, value: List<String>) // 데이터 하나 추가
    suspend fun insertDatumSQL(tableName: String, value: List<String>)
    suspend fun insertData(tableName: String, table: List<String>, values: List<List<String>>)
    suspend fun insertDataSQL(tableName: String, values: List<List<String>>)
    suspend fun readData(tableName: String): Flow<List<String>>
    suspend fun readDataSQL(tableName: String): Flow<List<String>>
    suspend fun readAllData(tableName: String): Flow<List<String>>
    suspend fun readAllDataSQL(tableName: String): Flow<List<String>>
    suspend fun updateDatum(tableName: String, table: List<String>, value: List<List<String>>)
    suspend fun updateAllData(tableName: String, table: String, value: List<List<String>>)
    suspend fun updateDatumSQL(tableName: String, table: List<String>, value: List<List<String>>)
    suspend fun updateAllDataSQL(tableName: String, value: List<List<String>>)
    suspend fun deleteData(tableName: String, table: String, deleteKey: Array<String>)
    suspend fun deleteAllData(tableName: String)   // 해당 테이블 데이터 전체 삭제 query
    suspend fun deleteDataSQL(tableName: String, table: String, deleteKey: List<String>)    // 해당 데이터 삭제 sql
    suspend fun deleteAllDataSQL(tableName: String) // 해당 테이블 데이터 전체 삭제 sql
    fun close()
}

class SQLiteDaoImpl(private val dbHelper: SQLiteHelper) : SQLiteDao {

////    override fun getAlphabetizedWords(): List<String> {
////        val db = dbHelper.readableDatabase
////        val cursor = db.query(
////            MyDatabaseHelper.TABLE_NAME,
////            arrayOf(MyDatabaseHelper.COLUMN_WORD),
////            null, null, null, null, "${MyDatabaseHelper.COLUMN_WORD} ASC"
////        )
////
////        val words = mutableListOf<String>()
////        with(cursor) {
////            while (moveToNext()) {
////                val word = getString(getColumnIndexOrThrow(MyDatabaseHelper.COLUMN_WORD))
////                words.add(word)
////            }
////        }
////        cursor.close()
////        return words
////    }
////
////    override fun insert(word: String) {
////        val db = dbHelper.writableDatabase
////        val values = ContentValues().apply {
////            put(MyDatabaseHelper.COLUMN_WORD, word)
////        }
////        db.insert(MyDatabaseHelper.TABLE_NAME, null, values)
////    }
////
////    override fun deleteAll() {
////        val db = dbHelper.writableDatabase
////        db.execSQL("DELETE FROM ${MyDatabaseHelper.TABLE_NAME}")
////    }
//
//    // INSERT 데이터 입력
//    override suspend fun insertDatum(tableName: String, value: List<String>) {
//        dbHelper.apply {
//        }
//    }
//
//    // SQL 데이터 입력
//    override suspend fun insertDatumSQL(tableName: String, value: List<String>) {
//        dbHelper.apply {
//
//            val sql = "INSERT INTO $tableName VALUES ('${value.joinToString { "', '" }}')"
//            writableDatabase.execSQL(sql)
//        }
//    }
//
//    // INSERT 데이터 입력
//    override suspend fun insertData(
//        tableName: String,
//        table: List<String>,
//        values: List<List<String>>
//    ) {
//        dbHelper.apply {
//
//            val cv = ContentValues()
//            for (i in values.indices) {
//                for (j in table.indices) {
//                    cv.put(table[j], values[i][j])
//                }
//                dbHelper.writableDatabase.insert(tableName, null, cv)
//            }
//        }
//    }
//
//    // SQL 여러 데이터 입력
//    override suspend fun insertDataSQL(tableName: String, values: List<List<String>>) {
//        dbHelper.apply {
//
//            for (i in values.indices) {
//                val sql =
//                    "INSERT INTO $tableName VALUES ('${values[i].joinToString { "', '" }}')"
//                writableDatabase.execSQL(sql)
//            }
//        }
//    }
//
//    // QUERY 모든 테이블 데이터 조회
//    override suspend fun readAllData(tableName: String): Flow<List<String>> = flow {
//        dbHelper.apply {
//
//            val cursor = readableDatabase.query(
//                tableName,
//                null,
//                null,
//                null,
//                null,
//                null,
//                null,
//            )
//            if (cursor.moveToFirst()) {
//                do {
//                    val data: MutableList<String> = mutableListOf()
//                    for (i in cursor.columnNames) {
//                        val columnIndex = cursor.getColumnIndex(i)
//                        val columnValue = cursor.getString(columnIndex)
//                        data.add(columnValue)
//                    }
//                    emit(data)
//                } while (
//                    cursor.moveToNext()
//                )
//            }
////                with(cursor) {
////                    while (moveToNext()) {
////                        val data = mutableMapOf<String, Any>()
////                        for (columnName in columnNames) {
////                            val columnIndex = getColumnIndex(columnName)
////                            val columnValue = when (getType(columnIndex)) {
////                                Cursor.FIELD_TYPE_INTEGER -> getInt(columnIndex)
////                                Cursor.FIELD_TYPE_FLOAT -> getFloat(columnIndex)
////                                Cursor.FIELD_TYPE_STRING -> getString(columnIndex)
////                                Cursor.FIELD_TYPE_BLOB -> getBlob(columnIndex)
////                                Cursor.FIELD_TYPE_NULL -> null
////                                else -> null
////                            }
////                            data[columnName] = columnValue
////                        }
////                        emit(data)
////                    }
////                }
//            cursor.close()
//        }
//    }
//
//    // SQL 모든 테이블 데이터 조회
//    override suspend fun readAllDataSQL(tableName: String): Flow<List<String>> =
//        flow {
//            dbHelper.apply {
//
//                val sql = "SELECT * FROM $tableName "
//                val cursor = readableDatabase.rawQuery(sql, null)
//                if (cursor.moveToFirst()) {
//                    do {
//                        val data: MutableList<String> = mutableListOf()
//                        for (i in cursor.columnNames) {
//                            val columnIndex = cursor.getColumnIndex(i)
//                            val columnValue = cursor.getString(columnIndex)
//                            data.add(columnValue)
//                        }
//                        emit(data)
//                    } while (
//                        cursor.moveToNext()
//                    )
//                }
//                cursor.close()
//            }
//        }
//
//    override suspend fun readData(tableName: String): Flow<List<String>> = flow {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun readDataSQL(tableName: String): Flow<List<String>> = flow {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun updateData(
//        tableName: String,
//        table: List<String>,
//        value: List<List<String>>
//    ) {
//        dbHelper.apply {
//
//            val wc = "${table[0]} = ?"
//            for (i in value.indices) {
//                val cv = ContentValues()
//                for (j in value[i].indices) {
//                    cv.put(table[j], value[i][j])
//                }
//                val wa: Array<String> = arrayOf(value[(value.size - 1) - i][0])
//                writableDatabase.update(tableName, cv, wc, wa)
//            }
//        }
//    }
//
//    override suspend fun updateAllData(
//        tableName: String,
//        table: String,
//        value: List<List<String>>
//    ) {
//        dbHelper.apply {
//
//            val cv = ContentValues()
//            val wc: String = "$table = ?"
//            val wa: Array<String> = arrayOf()
//            writableDatabase.update(tableName, cv, wc, wa)
//        }
//    }
//
//    override suspend fun updateDataSQL(
//        tableName: String,
//        table: List<String>,
//        value: List<List<String>>
//    ) {
//        dbHelper.apply {
//
//            if (value.isNotEmpty()) {
//                for (i in value.indices) {
//                    val sql = "UPDATE $tableName SET (${
//                        table.joinToString(", ")
//                    }) = ('${value[i].joinToString("', '")}') WHERE ${table[0]} = '${value[(value.size - 1) - i][0]}'"
//                    writableDatabase.execSQL(sql)
//                }
//            }
//        }
//    }
//
//    override suspend fun updateAllDataSQL(
//        tableName: String,
//        value: List<List<String>>
//    ) {
//        dbHelper.apply {
//
//            if (value.isNotEmpty()) {
//                for (i in value.indices) {
//                    val sql =
//                        "UPDATE FROM $tableName SET ${value[i].joinToString { "" }}"
//                    writableDatabase.execSQL(sql)
//                }
//            }
//        }
//    }
//
//    // DELETE 데이터 삭제
//    override suspend fun deleteData(
//        tableName: String,
//        table: String,
//        deleteKey: Array<String>
//    ) {
//        dbHelper.apply {
//
//            if (deleteKey.isNotEmpty()) {
//                val wc: String = "$table = ?"   // where
//                writableDatabase.delete(tableName, wc, deleteKey)
//            }
//        }
//    }
//
//    // SQL 데이터 삭제
//    override suspend fun deleteDataSQL(
//        tableName: String,
//        table: String,
//        deleteKey: List<String>
//    ) {
//        dbHelper.apply {
//
//            if (deleteKey.isNotEmpty()) {
//                val sql =
//                    "DELETE FROM $tableName WHERE COMP_CD = IN (${deleteKey.joinToString { ", " }})"
//                writableDatabase.execSQL(sql)
//            }
//        }
//    }
//
//    override fun close() {
//        dbHelper.close()
//    }
}