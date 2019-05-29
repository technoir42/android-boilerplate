package com.sch.android.boilerplate.inject

import android.app.Application
import com.facebook.flipper.core.FlipperClient
import com.sch.android.boilerplate.CombinedFeatureComponent
import com.sch.android.boilerplate.inject.modules.ApiModule
import com.sch.android.boilerplate.inject.modules.AppModule
import com.sch.android.boilerplate.inject.modules.DebugInitializerModule
import com.sch.android.boilerplate.inject.modules.DebugInterceptorModule
import com.sch.android.boilerplate.inject.modules.FlipperModule
import com.sch.android.boilerplate.inject.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        DebugInitializerModule::class,
        DebugInterceptorModule::class,
        FlipperModule::class,
        ViewModelModule::class
    ]
)
interface DebugAppComponent : AppComponent {
    override fun featureComponent(): CombinedFeatureComponent

    fun flipperClient(): FlipperClient

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): DebugAppComponent
    }
}
