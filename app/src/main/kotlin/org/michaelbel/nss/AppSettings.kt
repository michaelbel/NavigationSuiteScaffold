package org.michaelbel.nss

import androidx.compose.foundation.layout.Arrangement
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

    private val _navigationArrangementFlow = MutableStateFlow(Arrangement.Top)
    val navigationArrangementFlow: StateFlow<Arrangement.Vertical> = _navigationArrangementFlow.asStateFlow()

    fun setNavigationArrangement(arrangement: Arrangement.Vertical) {
        _navigationArrangementFlow.value = arrangement
    }
}
