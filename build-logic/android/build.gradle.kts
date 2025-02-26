plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

group = "com.convention.android.build-logic"

dependencies {
    implementation(projects.kotlin)
    implementation(projects.gradleExtension)
    implementation(libs.android.gradlePlugin)
    implementation(libs.ksp.gradlePlugin)
    implementation(libs.room.gradlePlugin)
}

gradlePlugin {
    plugins {
        create("convention.kotlin-android-app") {
            id = "convention.kotlin-android-app"
            implementationClass = "com.convention.AndroidApplicationConventionPlugin"
        }

        create("convention.kotlin-android-library") {
            id = "convention.kotlin-android-library"
            implementationClass = "com.convention.AndroidLibraryConventionPlugin"
        }

        create("convention.android-compose") {
            id = "convention.android-compose"
            implementationClass = "com.convention.compose.AndroidComposeConventionPlugin"
        }

        create("convention.hilt") {
            id = "convention.hilt"
            implementationClass = "com.convention.HiltConventionPlugin"
        }

        create("convention.room") {
            id = "convention.room"
            implementationClass = "com.convention.AndroidRoomConventionPlugin"
        }
    }
}