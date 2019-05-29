package com.sch.android.boilerplate.main

import com.sch.android.boilerplate.core.RxViewModel
import com.sch.neon.Effect
import com.sch.neon.EffectHandler
import com.sch.neon.Event
import com.sch.neon.MainLoop
import com.sch.neon.StateReducer
import com.sch.neon.StateWithEffects
import com.sch.neon.next
import com.sch.neon.timber.TimberLogger
import io.reactivex.Observable
import javax.inject.Inject

sealed class MainEvent : Event()
sealed class MainEffect : Effect()

data class MainViewState(
    val id: String = ""
)

class MainViewModel @Inject constructor(
    stateReducer: MainStateReducer,
    effectHandler: MainEffectHandler
) : RxViewModel() {

    lateinit var state: Observable<MainViewState>
    private val mainLoop = MainLoop(
        reducer = stateReducer,
        effectHandler = effectHandler,
        listener = TimberLogger(LOG_TAG)
    )

    fun init() {
        if (::state.isInitialized) return

        val initialState = MainViewState()
        state = mainLoop.loop(initialState).disposeOnDestroy()
    }

    companion object {
        private const val LOG_TAG = "MainViewModel"
    }
}

class MainEffectHandler @Inject constructor() : EffectHandler<MainEffect, MainEvent> {
    override fun handle(effects: Observable<MainEffect>): Observable<MainEvent> {
        return effects.ignoreElements().toObservable()
    }
}

class MainStateReducer @Inject constructor() : StateReducer<MainEvent, MainViewState, MainEffect> {
    override fun reduce(state: MainViewState, event: MainEvent): StateWithEffects<MainViewState, MainEffect> {
        return next(state)
    }
}
