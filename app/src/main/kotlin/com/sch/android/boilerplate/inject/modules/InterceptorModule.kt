package com.sch.android.boilerplate.inject.modules

import com.sch.android.boilerplate.core.network.ConnectivityCheckingInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import javax.inject.Named

@Module
object InterceptorModule {
    @Provides
    @JvmStatic
    fun provideInterceptors(): List<Interceptor> = emptyList()

    @Provides
    @Named("network")
    @JvmStatic
    fun provideNetworkInterceptors(connectivityCheckingInterceptor: ConnectivityCheckingInterceptor): List<Interceptor> =
        listOf(connectivityCheckingInterceptor)
}
