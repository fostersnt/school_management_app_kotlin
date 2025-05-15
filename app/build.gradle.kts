plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.kapt)

    alias(libs.plugins.google.services)
}

android {
    namespace = "com.loan_app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.loan_app"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //SPLASHSCREEN
    implementation(libs.androidx.splash.screen)

    //ADDED DEPENDENCIES
    // Jetpack Compose
//    implementation(libs.androidx.ui) //androidx.ui is coming from the libs.versions.toml
//    implementation(libs.androidx.material3)
//    implementation(libs.androidx.ui.tooling.preview)
//    debugImplementation(libs.androidx.ui.tooling)

    // Lifecycle + ViewModel Compose support
    implementation(libs.androidx.viewmodel.compose)

    // Hilt (Dependency Injection)
    implementation(libs.hilt.dagger)
    kapt(libs.hilt.compiler)
    implementation(libs.hilt.navigation)
//
//    // Retrofit (Networking)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)
//
    // Room (Local Database)
    implementation(libs.room.runtime)
    implementation(libs.room.compiler)

    // Coroutines (Flow / StateFlow / Async)
////    THIS DEPENDENCY CAUSES DUPLICATION. IT SEEMS SAME/SIMILAR DEPENDENCY EXISTS
    implementation(libs.kotlin.coroutines)
//
    // Accompanist (optional for system UI control)
    implementation(libs.system.ui.controller)

//    // Gson (JSON parser)
    implementation(libs.gson.parser)

//    //Live Data
    implementation (libs.livedata.runtime)

    //selection container
    implementation(libs.androidx.foundation)

    //Constraint Box
    implementation(libs.androidx.constraint.box)
    //Material2
    implementation(libs.androidx.material2)
    //AsyncImage
    implementation(libs.async.image)
    //Firebase Cloud service
    implementation(platform(libs.firebase.bom)) // ✅ Import the BoM
    implementation(libs.firebase.messaging)     // ✅ Messaging
//    implementation(libs.firebase.analytics)
    implementation (project(":libfacesdk"))

//    implementation("androidx.camera:camera-camera2:1.1.0")
//    implementation("androidx.camera:camera-lifecycle:1.1.0")
//    implementation()

}