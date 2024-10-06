plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.nasaxml"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.nasaxml"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
        buildConfig = true
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.fragment.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // Navigation Component
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.7")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation ("com.google.android.material:material:1.12.0")

    implementation ("androidx.cardview:cardview:1.0.0")



    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
    implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")
    // Dagger Hilt
    implementation ("com.google.dagger:hilt-android:2.47")
//    androidTestImplementation platform('androidx.compose:compose-bom:2023.03.00')
//    androidTestImplementation 'androidx.compose.ui:ui-test-junit4'
//    debugImplementation 'androidx.compose.ui:ui-tooling'
//    debugImplementation 'androidx.compose.ui:ui-test-manifest'
//    kapt ("com.google.dagger:hilt-android-compiler:2.47")
//    kapt ("androidx.hilt:hilt-compiler:1.2.0")
    // Paging
    implementation("androidx.databinding:databinding-runtime:8.3.2")
    implementation ("androidx.paging:paging-common-ktx:3.2.1")
    implementation ("androidx.paging:paging-runtime-ktx:3.2.1")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.2")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.2")

}