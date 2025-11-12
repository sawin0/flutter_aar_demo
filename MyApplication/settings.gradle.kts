pluginManagement {
    // Declare plugin versions here so module build files can use the plugins {} block without inline versions.
    plugins {
        id("com.android.application") version "8.13.1"
        id("org.jetbrains.kotlin.android") version "2.2.21"
    }

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

rootProject.name = "My Application"
include(":app")
