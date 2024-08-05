package com.ihateham.androidpractice.presentation.sqlite

import androidx.lifecycle.ViewModel
import com.ihateham.androidpractice.db.local.SQLiteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class SqliteViewModel(private val sqlite: SQLiteRepository) : ViewModel() {

    private var _selectData: MutableList<MutableList<String>>? = null
    val selectData get() = _selectData

    val selectDataSize: Int get() = _selectData?.size ?: 0

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