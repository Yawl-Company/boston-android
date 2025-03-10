plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

group = "com.convention.android.build-logic"

dependencies {
    compileOnly(gradleApi())
    // workaround for https://github.com/gradle/gradle/issues/15383
    api(files((libs as Any).javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        create("convention.gradle-secrets") {
            id = "convention.gradle-secrets"
            implementationClass = "com.convention.GradleSecretsConventionPlugin"
        }
    }
}