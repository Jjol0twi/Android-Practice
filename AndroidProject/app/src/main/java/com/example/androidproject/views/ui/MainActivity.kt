package com.example.androidproject.views.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import com.example.androidproject.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun hideSystemui() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            window.insetsController?.let {
                it.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())   // or로 사용하는 이유는 systembars(0x00000007), navigationbars(0x00000200)로 결합한 값으로 설정한다.
                it.systemBarsBehavior = // systembar의 동작을 제어
                    WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE    // Todo"이 속성에 대한 설명"
            }
        } else {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE    // 가장자리 스와이프 시 발동
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN    // full screen mode
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION  // hide bottom navigation bar
                    or View.SYSTEM_UI_FLAG_FULLSCREEN)
        }
    }
}