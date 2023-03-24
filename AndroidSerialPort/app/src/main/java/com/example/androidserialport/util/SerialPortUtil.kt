package com.example.androidserialport.util

import android.util.Log
import com.example.androidserialport.android_serialport_api.SerialPort
import java.io.File

class SerialPortUtil {
    private final val serialPORT = File("dev/ttysWK0")
    private final val serialBAUDRATE = 115200

    init {
        try {
            SerialPort(serialPORT, serialBAUDRATE, 0)
        } catch (e: Exception) {
            Log.d("error", e.toString())
        }
    }


    private fun setCommand(c: String) {

    }

    private fun readResponse() {

    }
}