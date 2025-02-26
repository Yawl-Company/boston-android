package com.boston.city

import android.app.Application
import com.boston.city.di.ApplicationComponent
import com.boston.city.di.DaggerApplicationComponent

class BostonApplication: Application() {
    private val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder().build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}
