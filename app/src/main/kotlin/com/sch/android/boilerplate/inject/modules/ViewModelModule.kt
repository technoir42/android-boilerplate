package com.sch.android.boilerplate.inject.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sch.android.boilerplate.core.DaggerViewModelFactory
import com.sch.android.boilerplate.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(impl: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ClassKey(MainViewModel::class)
    fun bindMainViewModel(impl: MainViewModel): ViewModel
}
