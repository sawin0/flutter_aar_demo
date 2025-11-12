plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

repositories {
    google()
    mavenCentral()
    maven { url = uri("../../sdk") }
    maven { url = uri("https://storage.googleapis.com/download.flutter.io") }
}

android {
    compileSdk = 36

    defaultConfig {
        applicationId = "com.sabin.myapplication"
        minSdk = 23
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        create("profile") {
            initWith(getByName("debug"))
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), file("proguard-rules.pro"))
        }
    }

    compileOptions {
        // Gradle 8.x and Android Gradle Plugin 8.x require Java 17+ for the toolchain.
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // Use Kotlin compiler DSL to specify JVM target via toolchain
    kotlin {
        jvmToolchain(17)
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
        // AGP is deprecating the project default for BuildConfig generation; explicitly enable it
        // to preserve the existing behavior and avoid the deprecation warning.
        buildConfig = true
    }

    namespace = "com.sabin.myapplication"
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("com.google.android.material:material:1.13.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")
    implementation("androidx.core:core-ktx:1.17.0")

    // Kotlin stdlib is provided by the Kotlin Gradle plugin; remove explicit older stdlib
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2")

    // AndroidX Test libraries should use testImplementation / androidTestImplementation appropriately
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test:runner:1.7.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.7.0")

    // Keep debug/profile/release variants for the embedded Flutter AAR module
    debugImplementation("com.example.flutter_module:flutter_debug:1.0")
    add("profileImplementation", "com.example.flutter_module:flutter_profile:1.0")
    add("releaseImplementation", "com.example.flutter_module:flutter_release:1.0")
}
