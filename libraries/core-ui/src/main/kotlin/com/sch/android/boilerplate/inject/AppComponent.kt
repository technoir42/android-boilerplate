package com.sch.android.boilerplate.inject

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.sch.android.boilerplate.core.init.Initializer

interface AppComponent {
    fun initializers(): Set<@JvmSuppressWildcards Initializer>

    fun featureComponent(): FeatureComponent

    fun viewModelFactory(): ViewModelProvider.Factory

    interface Holder {
        val appComponent: AppComponent
    }

    companion object {
        fun from(context: Context): AppComponent {
            return (context.applicationContext as Holder).appComponent
        }
    }
}
