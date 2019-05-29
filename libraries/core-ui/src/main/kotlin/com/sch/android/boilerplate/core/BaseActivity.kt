package com.sch.android.boilerplate.core

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), DisposableContainer by DisposableContainerImpl() {
    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposeAll()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        android.R.id.home -> {
            finishAfterTransition()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    protected abstract fun injectDependencies()
}
