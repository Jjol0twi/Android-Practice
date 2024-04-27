plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")    // Add the Google services Gradle plugin
}

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
// add the dependency for the Google Play services library and specify its version
    implementation("com.google.android.gms:play-services-auth:21.1.0")
// Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.8.1"))
    implementation("com.google.firebase:firebase-auth-ktx") // Add the dependency for the Firebase Authentication library
// naver login
    implementation("com.navercorp.nid:oauth:5.9.1") // jdk 11
}
