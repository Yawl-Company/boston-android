plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

group = "com.convention.android.build-logic"

dependencies {
    implementation(libs.android.gradlePlugin)
}

gradlePlugin {
    plugins {
        create("convention.signing") {
            id = "convention.signing"
            implementationClass = "com.convention.AndroidApplicationSignConventionPlugin"
        }
    }
}