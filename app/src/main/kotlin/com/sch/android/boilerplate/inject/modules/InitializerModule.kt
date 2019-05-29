package com.sch.android.boilerplate.inject.modules

import com.sch.android.boilerplate.core.init.AndroidThreeTenInitializer
import com.sch.android.boilerplate.core.init.Initializer
import com.sch.android.boilerplate.core.init.RxJavaInitializer
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
interface InitializerModule {
    @Binds
    @IntoSet
    fun bindAndroidThreeTenInitializer(impl: AndroidThreeTenInitializer): Initializer

    @Binds
    @IntoSet
    fun bindRxJavaInitializer(impl: RxJavaInitializer): Initializer
}
