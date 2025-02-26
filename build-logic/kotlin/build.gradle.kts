plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

group = "com.convention.android.build-logic"

dependencies {
    implementation(projects.gradleExtension)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        create("convention.kotlin-jvm") {
            id = "convention.kotlin-jvm"
            implementationClass = "com.convention.jvm.KotlinJvmPlugin"
        }

        create("convention.kotlin-jvm-android") {
            id = "convention.kotlin-jvm-android"
            implementationClass = "com.convention.jvm.KotlinJvmAndroidPlugin"
        }

        create("convention.ksp") {
            id = "convention.ksp"
            implementationClass = "com.convention.KspConventionPlugin"
        }

        create("convention.serialization") {
            id = "convention.serialization"
            implementationClass = "com.convention.KotlinSerializationPlugin"
        }
    }
}