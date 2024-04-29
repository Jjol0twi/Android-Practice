package com.ihateham.androidsampleproject

import android.app.Application
import android.content.pm.PackageManager
import com.ihateham.androidsampleproject.utils.Constants
import com.kakao.sdk.common.KakaoSdk
import com.navercorp.nid.NaverIdLoginSDK

class SampleApplication : Application() {
    override fun onCreate() {
        NaverIdLoginSDK.initialize(
            this,
            Constants.NAVER_CLIENT_ID,
            Constants.NAVER_CLIENT_SECRET,
            Constants.NAVER_CLIENT_NAME
        )
        val appInfo = packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA)
        appInfo.metaData.getString("kakao_native")?.let { KakaoSdk.init(this, it) }
        super.onCreate()
    }
}