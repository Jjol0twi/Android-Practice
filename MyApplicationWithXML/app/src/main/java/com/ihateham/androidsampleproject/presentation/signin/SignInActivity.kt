package com.ihateham.androidsampleproject.presentation.signin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ihateham.androidsampleproject.databinding.ActivitySigninBinding

class SigninActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}