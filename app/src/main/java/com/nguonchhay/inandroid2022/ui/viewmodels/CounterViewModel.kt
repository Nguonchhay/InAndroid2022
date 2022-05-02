package com.nguonchhay.inandroid2022.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    var counterState = MutableLiveData<Int>()
    private var counter: Int = 0

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
}