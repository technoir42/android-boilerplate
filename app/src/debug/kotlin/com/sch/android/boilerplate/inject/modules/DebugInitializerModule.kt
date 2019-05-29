package com.sch.android.boilerplate.inject.modules

import com.sch.android.boilerplate.core.init.FlipperInitializer
import com.sch.android.boilerplate.core.init.Initializer
import com.sch.android.boilerplate.core.init.TimberInitializer
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module(includes = [InitializerModule::class])
interface DebugInitializerModule {
    @Binds
    @IntoSet
    fun bindFlipperInitializer(impl: FlipperInitializer): Initializer

    @Binds
    @IntoSet
    fun bindTimberInitializer(impl: TimberInitializer): Initializer
}
