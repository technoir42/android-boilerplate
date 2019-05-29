package com.sch.android.boilerplate.inject.modules

import com.facebook.flipper.core.FlipperClient
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.sch.android.boilerplate.core.network.ConnectivityCheckingInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Named

@Module
object DebugInterceptorModule {
    @Provides
    @JvmStatic
    fun provideInterceptors(): List<Interceptor> =
        listOf(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))

    @Provides
    @JvmStatic
    @Named("network")
    fun provideNetworkInterceptors(connectivityCheckingInterceptor: ConnectivityCheckingInterceptor, flipperClient: FlipperClient): List<Interceptor> =
        listOf(connectivityCheckingInterceptor, FlipperOkhttpInterceptor(flipperClient.getPlugin(NetworkFlipperPlugin.ID)))
}
