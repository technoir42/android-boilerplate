package com.sch.android.boilerplate

import com.sch.android.boilerplate.core.BaseApplication
import com.sch.android.boilerplate.inject.DaggerReleaseAppComponent
import com.sch.android.boilerplate.inject.ReleaseAppComponent

class BoilerplateApplication : BaseApplication() {
    override val appComponent: ReleaseAppComponent by lazy(LazyThreadSafetyMode.NONE) {
        DaggerReleaseAppComponent.factory().create(this)
    }
}
