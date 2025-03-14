package com.convention.compose

import com.android.build.api.dsl.CommonExtension
import com.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply(libs.plugins.kotlin.compose.get().pluginId)

            extensions.configure(CommonExtension::class.java) { android ->
                with(android) {
                    buildFeatures {
                        compose = true
                    }

                    composeOptions {
                        kotlinCompilerExtensionVersion =
                            libs.versions.androidxComposeCompiler.get().toString()
                    }

                    val bom = libs.androidx.compose.bom.get()
                    dependencies.apply {
                        add("implementation", platform(bom))
                        add("androidTestImplementation", platform(bom))
                        add("implementation", libs.androidx.compose.ui.tooling.preview.get())
                        add("debugImplementation", libs.androidx.compose.ui.tooling.base.get())
                    }
                }
            }
        }
    }
}