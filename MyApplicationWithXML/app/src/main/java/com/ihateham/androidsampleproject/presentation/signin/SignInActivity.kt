package com.ihateham.androidsampleproject.presentation.signin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ihateham.androidsampleproject.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    private val oauthLoginCallback = object : OAuthLoginCallback {
        override fun onSuccess() {
            Log.i("success", "get access token(${NaverIdLoginSDK.getAccessToken()})")
        }

        override fun onFailure(httpStatus: Int, message: String) {
            val errorCode = NaverIdLoginSDK.getLastErrorCode().code
            val errorDescription = NaverIdLoginSDK.getLastErrorDescription()
            Log.i("fail", "Naver Login Fail:$errorCode, errorDesc:$errorDescription")
        }

        override fun onError(errorCode: Int, message: String) {
            onFailure(errorCode, message)
        }
    }

}