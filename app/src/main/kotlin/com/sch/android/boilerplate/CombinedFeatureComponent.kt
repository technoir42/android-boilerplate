package com.sch.android.boilerplate

import com.sch.android.boilerplate.inject.FeatureComponent
import com.sch.android.boilerplate.main.MainComponent
import dagger.Subcomponent

@Subcomponent
interface CombinedFeatureComponent :
    FeatureComponent,
    MainComponent
