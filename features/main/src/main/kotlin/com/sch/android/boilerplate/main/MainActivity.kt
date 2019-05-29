package com.sch.android.boilerplate.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.sch.android.boilerplate.core.BaseActivity
import com.sch.android.boilerplate.core.extensions.setActionBar
import com.sch.android.boilerplate.inject.getComponent
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class MainActivity : BaseActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar(R.id.toolbar)

        viewModel.init()
        viewModel.state
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { renderState(it) }
            .disposeOnDestroy()
    }

    private fun renderState(state: MainViewState) {
        state.toString()
    }

    override fun injectDependencies() {
        getComponent<MainComponent>().inject(this)
    }
}
