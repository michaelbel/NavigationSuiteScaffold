package org.michaelbel.nss

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object AppSettings {

    private val _dynamicColorsFlow = MutableStateFlow(false)
    val dynamicColorsFlow: StateFlow<Boolean> = _dynamicColorsFlow.asStateFlow()

    fun toggleDynamicColors() {
        _dynamicColorsFlow.value = !dynamicColorsFlow.value
    }

    private val _navigationVisibleFlow = MutableStateFlow(true)
    val navigationVisibleFlow: StateFlow<Boolean> = _navigationVisibleFlow.asStateFlow()

    fun toggleNavigationVisible() {
        _navigationVisibleFlow.value = !_navigationVisibleFlow.value
    }
}
