package org.michaelbel.nss

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object AppSettings {

    private val _dynamicColorsEnabled = MutableStateFlow(false)
    val dynamicColorsFlow: StateFlow<Boolean> = _dynamicColorsEnabled.asStateFlow()

    fun setDynamicColors(enabled: Boolean) {
        _dynamicColorsEnabled.value = enabled
    }
}