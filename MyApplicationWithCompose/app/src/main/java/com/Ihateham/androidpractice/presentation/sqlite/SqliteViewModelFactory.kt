package com.Ihateham.androidpractice.presentation.sqlite

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.Ihateham.androidpractice.db.local.SQLiteDaoImpl
import com.Ihateham.androidpractice.db.local.SQLiteHelper

class SqliteViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val _SQLiteHelper = SQLiteHelper(context)   // 임시로
    private val sqlite = SQLiteDaoImpl(_SQLiteHelper)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SqliteViewModel::class.java)) {
            return SqliteViewModel(sqlite) as T
        } else {
            throw IllegalArgumentException("Not found main view model class")
        }
    }
}