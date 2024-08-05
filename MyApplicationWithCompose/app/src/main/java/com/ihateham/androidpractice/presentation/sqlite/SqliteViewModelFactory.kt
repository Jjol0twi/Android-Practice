package com.ihateham.androidpractice.presentation.sqlite

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ihateham.androidpractice.db.local.SQLiteDaoImpl
import com.ihateham.androidpractice.db.local.SQLiteHelper
import com.ihateham.androidpractice.db.local.SQLiteRepository

class SqliteViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val sqliteHelper = SQLiteHelper.getInstance(context)
    private val sqliteRepo = SQLiteRepository(sqliteHelper, SQLiteDaoImpl(sqliteHelper))
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SqliteViewModel::class.java)) {
            return SqliteViewModel(sqliteRepo) as T
        } else {
            throw IllegalArgumentException("Not found main view model class")
        }
    }
}