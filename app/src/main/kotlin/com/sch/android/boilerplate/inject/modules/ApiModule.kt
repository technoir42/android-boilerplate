package com.sch.android.boilerplate.inject.modules

import com.sch.android.boilerplate.BuildConfig
import com.sch.android.boilerplate.core.api.ApiConfiguration
import com.sch.android.boilerplate.core.network.OkHttpClientFactory
import com.squareup.moshi.Moshi
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
object ApiModule {
    @Provides
    @Singleton
    @JvmStatic
    fun provideOkHttpClient(factory: OkHttpClientFactory): OkHttpClient {
        return factory.createClient()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideRetrofit(okHttpClient: Lazy<OkHttpClient>, apiConfig: ApiConfiguration, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .callFactory { okHttpClient.get().newCall(it) }
            .baseUrl(apiConfig.url)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .validateEagerly(BuildConfig.DEBUG)
            .build()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideMoshi(): Moshi {
        return Moshi.Builder().build()
    }

    @Provides
    @Reusable
    @JvmStatic
    fun provideApiConfig(): ApiConfiguration {
        return ApiConfiguration(url = "REPLACE ME")
    }
}
