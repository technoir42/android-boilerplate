package com.sch.android.boilerplate

import com.sch.android.boilerplate.core.BaseApplication
import com.sch.android.boilerplate.inject.DaggerDebugAppComponent
import com.sch.android.boilerplate.inject.DebugAppComponent

class DebugBoilerplateApplication : BaseApplication() {
    override val appComponent: DebugAppComponent by lazy(LazyThreadSafetyMode.NONE) {
        DaggerDebugAppComponent.factory().create(this)
    }
}
