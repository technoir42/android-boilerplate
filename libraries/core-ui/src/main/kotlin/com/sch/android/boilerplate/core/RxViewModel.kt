package com.sch.android.boilerplate.core

import androidx.lifecycle.ViewModel

abstract class RxViewModel : ViewModel(), DisposableContainer by DisposableContainerImpl() {
    override fun onCleared() {
        super.onCleared()
        disposeAll()
    }
}
