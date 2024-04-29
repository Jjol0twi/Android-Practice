import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")    // Add the Google services Gradle plugin
}

fun getKey(name: String): String = gradleLocalProperties(rootDir, providers).getProperty(name)

android {
    namespace = "com.ihateham.androidsampleproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ihateham.androidsampleproject"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "0.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "NAVER_CLIENT_ID", getKey("naver.client"))
        buildConfigField("String", "NAVER_CLIENT_SECRET", getKey("naver.secret"))
        buildConfigField("String", "NAVER_CLIENT_NAME", getKey("naver.applicationName"))
        buildConfigField("String", "GOOGLE_WEB_CLIENT", getKey("google.webClient"))
        manifestPlaceholders["KAKAO_NATIVE_KEY"] = getKey("kakao.native") as String
    }

    buildTypes {
        debug {
            isMinifyEnabled = false

        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.activity:activity-ktx:1.9.0")
    implementation("androidx.fragment:fragment-ktx:1.6.2")
//  google material components
    implementation("com.google.android.material:material:1.11.0")
// testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//  room
    implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-runtime:2.6.1")
// navigation
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
//  viewmodelscope
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
//  retrofit2
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0") // gson converter
// Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.8.1"))
// google login
    implementation("com.firebaseui:firebase-ui-auth:8.0.2") // FirebaseUI for Firebase Auth
    // keep gms version 20.7.0 beacuase 21.1.0 doesn't apply firebase ui login
    implementation("com.google.android.gms:play-services-auth:20.7.0")  // add the dependency for the Google Play services library and specify its version
    implementation("com.google.firebase:firebase-auth-ktx") // Add the dependency for the Firebase Authentication library
// naver login
    implementation("com.navercorp.nid:oauth:5.9.1") // jdk 11
// kakao login
    implementation("com.kakao.sdk:v2-user:2.20.1") // 카카오 로그인 API 모듈

}
