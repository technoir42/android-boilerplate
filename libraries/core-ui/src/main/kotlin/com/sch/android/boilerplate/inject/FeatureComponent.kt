package com.sch.android.boilerplate.inject

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment

interface FeatureComponent {
    companion object {
        private var instance: FeatureComponent? = null

        fun from(context: Context): FeatureComponent {
            return instance
                ?: AppComponent.from(context).featureComponent().also { instance = it }
        }
    }
}

inline fun <reified ComponentType> Activity.getComponent(): ComponentType {
    return FeatureComponent.from(this) as ComponentType
}

inline fun <reified ComponentType> Fragment.getComponent(): ComponentType {
    return FeatureComponent.from(requireContext()) as ComponentType
}
