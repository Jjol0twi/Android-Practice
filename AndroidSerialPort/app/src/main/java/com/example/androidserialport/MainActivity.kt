package com.example.androidserialport

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import com.example.androidserialport.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object{
        fun load(){
            System.loadLibrary("serial_port")
        }
    }

    init {
        load()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val text_main=binding.textMain
        setContentView(binding.root)
    }



}