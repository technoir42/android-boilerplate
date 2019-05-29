package com.sch.android.boilerplate.inject

import android.app.Application
import com.sch.android.boilerplate.CombinedFeatureComponent
import com.sch.android.boilerplate.inject.modules.ApiModule
import com.sch.android.boilerplate.inject.modules.AppModule
import com.sch.android.boilerplate.inject.modules.InitializerModule
import com.sch.android.boilerplate.inject.modules.InterceptorModule
import com.sch.android.boilerplate.inject.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        InitializerModule::class,
        InterceptorModule::class,
        ViewModelModule::class
    ]
)
interface ReleaseAppComponent : AppComponent {
    override fun featureComponent(): CombinedFeatureComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ReleaseAppComponent
    }
}
