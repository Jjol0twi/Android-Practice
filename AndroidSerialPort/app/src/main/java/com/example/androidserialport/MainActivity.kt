package com.example.androidserialport

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.androidserialport.android_serialport_api.SerialPort
import com.example.androidserialport.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mSerialport: SerialPort
    private val serialPORT = File("/dev/ttysWK0")
    private val serialBAUDRATE = 115200

    companion object {
        fun load() {
            System.loadLibrary("serial_port")
        }
    }

    init {
//        load()
        try {
            System.loadLibrary("serial_port")
        } catch (e: Exception) {
            Log.d("error", e.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        try {
            mSerialport = SerialPort(serialPORT, serialBAUDRATE, 0)
        } catch (e: Exception) {
            Log.d("error", e.toString())
        }
        val textMain = binding.textMain
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        mSerialport.close()
    }

}