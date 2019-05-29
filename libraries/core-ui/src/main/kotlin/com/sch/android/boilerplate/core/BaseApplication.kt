package com.sch.android.boilerplate.core

import android.app.Application
import com.sch.android.boilerplate.inject.AppComponent

abstract class BaseApplication : Application(), AppComponent.Holder {
    override fun onCreate() {
        super.onCreate()

        appComponent.initializers().asSequence()
            .sortedByDescending { it.priority }
            .forEach { it.initialize() }
    }
}
