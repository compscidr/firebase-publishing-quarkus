import com.google.firebase.appdistribution.gradle.firebaseAppDistribution

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.firebase.app.distribution)
}

android {
    namespace = "com.jasonernst.kts"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jasonernst.kts"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
    }

    dependencies {
        implementation(libs.androidx.appcompat)
    }

    buildTypes {
        getByName("release") {
            firebaseAppDistribution {
                artifactType = "APK"
                testers = "ernstjason1@gmail.com"
            }
        }
    }
}

kotlin {
    jvmToolchain(17)
}
