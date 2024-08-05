package com.ihateham.androidpractice.presentation.sqlite

import androidx.lifecycle.ViewModel
import com.ihateham.androidpractice.db.local.SQLiteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class SqliteViewModel(private val sqlite: SQLiteDao) : ViewModel() {
    private val _readData: Flow<List<String>> = flowOf(listOf())
    val readData: Flow<List<String>> get() = _readData

    fun addDB() {
//        sqlite.insertData()
    }

    fun readDB() {
//        sqlite.readAllData()
    }

    fun updateDB() {
//        sqlite.updateData()
    }

    fun deleteDb() {
//        sqlite.deleteData()
    }
}