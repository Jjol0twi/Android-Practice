package com.ihateham.androidsampleproject.presentation.payment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ihateham.androidsampleproject.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() = with(binding) {
    }
}