@file:Suppress("DEPRECATION") // Suppress for WindowWidthSizeClass

package org.michaelbel.nss

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItem
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.material3.adaptive.navigationsuite.rememberNavigationSuiteScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import kotlinx.coroutines.launch

@Preview
@Composable
fun NavigationSuiteScaffoldSample() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val navItems = listOf("Songs", "Artists", "Playlists")
    val navSuiteType = NavigationSuiteScaffoldDefaults.navigationSuiteType(currentWindowAdaptiveInfo())
    val state = rememberNavigationSuiteScaffoldState()
    val scope = rememberCoroutineScope()

    NavigationSuiteScaffold(
        state = state,
        navigationItems = {
            navItems.forEachIndexed { index, navItem ->
                NavigationSuiteItem(
                    icon = {
                        Icon(
                            if (selectedItem == index) Icons.Filled.Favorite
                            else Icons.Outlined.FavoriteBorder,
                            contentDescription = null,
                        )
                    },
                    label = { Text(navItem) },
                    selected = selectedItem == index,
                    onClick = { selectedItem = index },
                )
            }
        },
    ) {
        // Screen content.
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text =
                    "Current NavigationSuiteType: $navSuiteType\n" +
                        "Visibility: ${state.currentValue}",
                textAlign = TextAlign.Center,
            )
            Button(onClick = { scope.launch { state.toggle() } }) {
                Text("Hide/show navigation component")
            }
        }
    }
}

@Preview
@Composable
@Suppress("DEPRECATION") // WindowWidthSizeClass is deprecated
fun NavigationSuiteScaffoldCustomConfigSample() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val navItems = listOf("Songs", "Artists", "Playlists")
    // Custom configuration that shows a wide navigation rail in small/medium width screens, an
    // expanded wide navigation rail in expanded width screens, and a short navigation bar in small
    // height screens.
    val navSuiteType =
        with(currentWindowAdaptiveInfo()) {
            if (
                windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.COMPACT ||
                    windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.MEDIUM
            ) {
                NavigationSuiteType.WideNavigationRailCollapsed
            } else if (windowSizeClass.windowHeightSizeClass == WindowHeightSizeClass.COMPACT) {
                NavigationSuiteType.ShortNavigationBarMedium
            } else if (windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.EXPANDED) {
                NavigationSuiteType.WideNavigationRailExpanded
            } else {
                NavigationSuiteScaffoldDefaults.navigationSuiteType(currentWindowAdaptiveInfo())
            }
        }
    val state = rememberNavigationSuiteScaffoldState()
    val scope = rememberCoroutineScope()

    NavigationSuiteScaffold(
        navigationSuiteType = navSuiteType,
        state = state,
        navigationItemVerticalArrangement = Arrangement.Center,
        navigationItems = {
            navItems.forEachIndexed { index, navItem ->
                NavigationSuiteItem(
                    navigationSuiteType = navSuiteType,
                    icon = {
                        Icon(
                            if (selectedItem == index) Icons.Filled.Favorite
                            else Icons.Outlined.FavoriteBorder,
                            contentDescription = null,
                        )
                    },
                    label = { Text(navItem) },
                    selected = selectedItem == index,
                    onClick = { selectedItem = index },
                )
            }
        },
    ) {
        // Screen content.
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text =
                    "Current NavigationSuiteType: $navSuiteType\n" +
                        "Visibility: ${state.currentValue}",
                textAlign = TextAlign.Center,
            )
            Button(onClick = { scope.launch { state.toggle() } }) {
                Text("Hide/show navigation component")
            }
        }
    }
}
