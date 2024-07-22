package com.Ihateham.androidpractice.db.local

import android.content.ContentValues
import android.database.Cursor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface SQLiteDao {
    suspend fun insertData(tableName: String)
    suspend fun insertDataSQL(tableName: String)
    suspend fun readData(tableName: String): Flow<List<String>>
    suspend fun readDataSQL(tableName: String): Flow<List<String>>
    suspend fun readAllData(tableName: String): Flow<List<String>>
    suspend fun readAllDataSQL(tableName: String): Flow<List<String>>
    suspend fun updateData(tableName: String)
    suspend fun updateDataSQL(tableName: String)
    suspend fun deleteData(tableName: String)
    suspend fun deleteDataSQL(tableName: String)
}

class SQLiteDaoImpl(private val dbHelper: SQLiteHelper) : SQLiteDao {

    override suspend fun insertData(tableName: String) {
        dbHelper.apply {
            runInTransaction {
                val cv = ContentValues()
                dbHelper.writableDatabase.insert(tableName, null, cv)
            }
        }
    }

    override suspend fun insertDataSQL(tableName: String) {
        dbHelper.apply {
            runInTransaction {
                val sql = "INSERT INTO $tableName VALUES ('')"
                writableDatabase.execSQL(sql)
            }
        }
    }

    override suspend fun readAllData(tableName: String): Flow<List<String>> = flow {
        dbHelper.apply {
            runInTransaction {
                val cursor = readableDatabase.query(
                    tableName,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                )
                if (cursor.moveToFirst()) {
                    do {
                        val data: MutableList<String> = mutableListOf()
                        for (i in cursor.columnNames) {
                            val columnIndex = cursor.getColumnIndex(i)
                            val columnValue = cursor.getString(columnIndex)
                            data.add(columnValue)
                        }
                        emit(data)
                    } while (
                        cursor.moveToNext()
                    )
                }
//                with(cursor) {
//                    while (moveToNext()) {
//                        val data = mutableMapOf<String, Any>()
//                        for (columnName in columnNames) {
//                            val columnIndex = getColumnIndex(columnName)
//                            val columnValue = when (getType(columnIndex)) {
//                                Cursor.FIELD_TYPE_INTEGER -> getInt(columnIndex)
//                                Cursor.FIELD_TYPE_FLOAT -> getFloat(columnIndex)
//                                Cursor.FIELD_TYPE_STRING -> getString(columnIndex)
//                                Cursor.FIELD_TYPE_BLOB -> getBlob(columnIndex)
//                                Cursor.FIELD_TYPE_NULL -> null
//                                else -> null
//                            }
//                            data[columnName] = columnValue
//                        }
//                        emit(data)
//                    }
//                }
                cursor.close()
            }
        }
    }

    override suspend fun readAllDataSQL(tableName: String): Flow<List<String>> = flow {
        dbHelper.apply {
            runInTransaction {
                val sql = "SELECT * FROM $tableName "
                val cursor = readableDatabase.rawQuery(sql, null)
                if (cursor.moveToFirst()) {
                    do {
                        val data: MutableList<String> = mutableListOf()
                        for (i in cursor.columnNames) {
                            val columnIndex = cursor.getColumnIndex(i)
                            val columnValue = cursor.getString(columnIndex)
                            data.add(columnValue)
                        }
                        emit(data)
                    } while (
                        cursor.moveToNext()
                    )
                }
                cursor.close()
            }
        }
    }

    override suspend fun readData(tableName: String): Flow<List<String>> = flow {
        TODO("Not yet implemented")
    }

    override suspend fun readDataSQL(tableName: String): Flow<List<String>> = flow {
        TODO("Not yet implemented")
    }

    override suspend fun updateData(tableName: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateDataSQL(tableName: String) {
        dbHelper.apply {
            runInTransaction {
                val sql = "UPDATE FROM $tableName SET "
//                if (){
//                sql+" WHERE"
//            }
                writableDatabase.execSQL(sql)
            }
        }
    }

    override suspend fun deleteData(tableName: String) {
        dbHelper.apply {
            runInTransaction {
                val wc: String = "id = ?"   // where
                val wf: Array<String> = arrayOf()
                writableDatabase.delete(tableName, wc, wf)
            }
        }
    }

    override suspend fun deleteDataSQL(tableName: String) {
        dbHelper.apply {
            runInTransaction {
                val sql = "DELETE FROM $tableName "
//                if (){
//                sql+" WHERE"
//            }
                writableDatabase.execSQL(sql)
            }
        }
    }
}