package org.michaelbel.nss

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface AppRoute: NavKey {

    @Serializable
    data object Home: AppRoute

    @Serializable
    data class Details(val boarId: Int): AppRoute
}

sealed interface Tabs {

    @Serializable
    data object Home: Tabs

    @Serializable
    data object Settings: Tabs

    @Serializable
    data object About: Tabs
}
