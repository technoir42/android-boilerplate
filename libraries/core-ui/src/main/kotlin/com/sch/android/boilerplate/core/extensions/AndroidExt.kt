package com.sch.android.boilerplate.core.extensions

import androidx.annotation.IdRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat

fun AppCompatActivity.setActionBar(@IdRes toolbarId: Int, configure: ActionBar.() -> Unit = {}): Toolbar {
    val toolbar = ActivityCompat.requireViewById<Toolbar>(this, toolbarId)
    setSupportActionBar(toolbar)
    supportActionBar!!.configure()
    return toolbar
}
