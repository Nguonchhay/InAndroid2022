package com.nguonchhay.inandroid2022.ui.composes.viewmodels

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorComposeViewModel : ViewModel() {
    var resultState = mutableStateOf("")

    fun sum(value1: Double, value2: Double) {
        resultState.value = (value1 + value2).toString()
    }

    fun minus(value1: Double, value2: Double) {
        resultState.value = (value1 - value2).toString()
    }

    fun mul(value1: Double, value2: Double) {
        resultState.value = (value1 * value2).toString()
    }
}

val CalculatorState = compositionLocalOf<CalculatorComposeViewModel> {
    error("Calculator Context is not found")
}