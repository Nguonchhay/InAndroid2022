package com.nguonchhay.inandroid2022.ui.viewmodels

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    var counterState = MutableLiveData<Int>()
    private var counter: Int = 0
    private var isStart: Boolean = false
    private val DELAY = 1000L

    init {
        counterState.value = counter
    }

    fun increase() {
        counter++
        counterState.value = counter
    }

    fun decrease() {
        counterState.value = --counter
    }

    private fun counterRunner() {
        if (isStart) {
            increase()
            loopCounter()
        }
    }

    private fun loopCounter() {
        Handler(Looper.getMainLooper()).postDelayed(
            { counterRunner() },
            DELAY
        )
    }

    fun startCounter() {
        isStart = true
        loopCounter()
    }

    fun stopCounter() {
        isStart = false
    }
}