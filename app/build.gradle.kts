plugins {
    alias(libs.plugins.convention.android.application)
    alias(libs.plugins.convention.android.compose)
    alias(libs.plugins.convention.android.dagger)
    alias(libs.plugins.convention.android.unit.test)
    alias(libs.plugins.convention.android.ui.test)
    alias(libs.plugins.convention.signing)
}

android {
    namespace = "com.boston.city"

    defaultConfig {
        applicationId = "com.boston.city"
        versionCode = 1
        versionName = "1.0"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
}