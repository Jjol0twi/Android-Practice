package com.ihateham.androidsampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ihateham.androidsampleproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding //xml이름+Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
