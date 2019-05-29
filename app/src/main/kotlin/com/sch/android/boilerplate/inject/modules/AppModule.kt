package com.sch.android.boilerplate.inject.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppModule {
    @Binds
    abstract fun bindAppContext(application: Application): Context

    @Module
    companion object {
        @Provides
        @JvmStatic
        @Singleton
        fun provideSharedPreferences(context: Context): SharedPreferences {
            return PreferenceManager.getDefaultSharedPreferences(context)
        }
    }
}
