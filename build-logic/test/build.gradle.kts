plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

group = "com.convention.android.build-logic"

dependencies {
    implementation(projects.gradleExtension)
    implementation(libs.android.gradlePlugin)
}

gradlePlugin {
    plugins {
        create("convention.unit") {
            id = "convention.unit"
            implementationClass = "com.convention.AndroidUnitTestConventionPlugin"
        }

        create("convention.ui") {
            id = "convention.ui"
            implementationClass = "com.convention.AndroidUiTestConventionPlugin"
        }
    }
}