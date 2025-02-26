package com.convention

import org.gradle.api.Plugin
import org.gradle.api.Project

class DaggerConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply(KspConventionPlugin::class.java)

            dependencies.apply {
                add("ksp", libs.dagger.compiler.get())
                add("implementation", libs.dagger.android.get())
            }
        }
    }
}