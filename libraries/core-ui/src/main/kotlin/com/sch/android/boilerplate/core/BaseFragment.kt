package com.sch.android.boilerplate.core

import android.content.Context
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(), DisposableContainer by DisposableContainerImpl() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectDependencies()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposeAll()
    }

    protected abstract fun injectDependencies()
}
