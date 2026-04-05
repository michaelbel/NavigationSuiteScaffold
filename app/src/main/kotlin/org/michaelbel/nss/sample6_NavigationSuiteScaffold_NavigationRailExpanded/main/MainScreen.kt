@file:OptIn(ExperimentalMaterial3AdaptiveApi::class)

package org.michaelbel.nss.sample6_NavigationSuiteScaffold_NavigationRailExpanded.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowDpSize
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.michaelbel.nss.sample6_NavigationSuiteScaffold_NavigationRailExpanded.main.about.AboutScreen
import org.michaelbel.nss.sample6_NavigationSuiteScaffold_NavigationRailExpanded.main.home.HomeScreen
import org.michaelbel.nss.sample6_NavigationSuiteScaffold_NavigationRailExpanded.main.settings.SettingsScreen
import org.michaelbel.nss.Tabs

@Composable
fun MainScreen(
    onNavigateToDetails: (Int) -> Unit
) {
    var selectedTab by rememberSaveable(stateSaver = Tabs.Saver) { mutableStateOf(Tabs.Home) }

    val windowAdaptiveInfo = currentWindowAdaptiveInfo()
    val windowDpSize = currentWindowDpSize()
    val navigationSuiteType = when {
        windowDpSize.width >= 1200.dp -> NavigationSuiteType.WideNavigationRailExpanded
        else -> NavigationSuiteScaffoldDefaults.navigationSuiteType(windowAdaptiveInfo)
    }
    val isNavigationRail = navigationSuiteType == NavigationSuiteType.WideNavigationRailCollapsed ||
            navigationSuiteType == NavigationSuiteType.WideNavigationRailExpanded

    NavigationSuiteScaffold(
        navigationItems = {
            when (navigationSuiteType) {
                NavigationSuiteType.WideNavigationRailCollapsed -> {
                    NavigationRail(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        NavigationRailItem(
                            selected = selectedTab == Tabs.Home,
                            onClick = { selectedTab = Tabs.Home },
                            icon = {
                                Icon(
                                    imageVector = Icons.Outlined.Home,
                                    contentDescription = null
                                )
                            },
                            label = {
                                Text(
                                    text = "Home"
                                )
                            }
                        )

                        NavigationRailItem(
                            selected = selectedTab == Tabs.Settings,
                            onClick = { selectedTab = Tabs.Settings },
                            icon = {
                                Icon(
                                    imageVector = Icons.Outlined.Settings,
                                    contentDescription = null
                                )
                            },
                            label = {
                                Text(
                                    text = "Settings"
                                )
                            }
                        )

                        NavigationRailItem(
                            selected = selectedTab == Tabs.About,
                            onClick = { selectedTab = Tabs.About },
                            icon = {
                                Icon(
                                    imageVector = Icons.Outlined.Info,
                                    contentDescription = null
                                )
                            },
                            label = {
                                Text(
                                    text = "About"
                                )
                            }
                        )
                    }
                }
                NavigationSuiteType.WideNavigationRailExpanded -> {
                    ModalDrawerSheet(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            NavigationDrawerItem(
                                selected = selectedTab == Tabs.Home,
                                onClick = { selectedTab = Tabs.Home },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Outlined.Home,
                                        contentDescription = null
                                    )
                                },
                                label = {
                                    Text(
                                        text = "Home"
                                    )
                                }
                            )

                            NavigationDrawerItem(
                                selected = selectedTab == Tabs.Settings,
                                onClick = { selectedTab = Tabs.Settings },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Outlined.Settings,
                                        contentDescription = null
                                    )
                                },
                                label = {
                                    Text(
                                        text = "Settings"
                                    )
                                }
                            )

                            NavigationDrawerItem(
                                selected = selectedTab == Tabs.About,
                                onClick = { selectedTab = Tabs.About },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Outlined.Info,
                                        contentDescription = null
                                    )
                                },
                                label = {
                                    Text(
                                        text = "About"
                                    )
                                }
                            )
                        }
                    }
                }
                else -> {
                    BottomAppBar(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        NavigationBarItem(
                            selected = selectedTab == Tabs.Home,
                            onClick = { selectedTab = Tabs.Home },
                            icon = {
                                Icon(
                                    imageVector = Icons.Outlined.Home,
                                    contentDescription = null
                                )
                            },
                            label = {
                                Text(
                                    text = "Home"
                                )
                            }
                        )

                        NavigationBarItem(
                            selected = selectedTab == Tabs.Settings,
                            onClick = { selectedTab = Tabs.Settings },
                            icon = {
                                Icon(
                                    imageVector = Icons.Outlined.Settings,
                                    contentDescription = null
                                )
                            },
                            label = {
                                Text(
                                    text = "Settings"
                                )
                            }
                        )

                        NavigationBarItem(
                            selected = selectedTab == Tabs.About,
                            onClick = { selectedTab = Tabs.About },
                            icon = {
                                Icon(
                                    imageVector = Icons.Outlined.Info,
                                    contentDescription = null
                                )
                            },
                            label = {
                                Text(
                                    text = "About"
                                )
                            }
                        )
                    }
                }
            }
        },
        navigationSuiteType = navigationSuiteType
    ) {
        when (selectedTab) {
            Tabs.Home -> {
                HomeScreen(
                    isNavigationRail = isNavigationRail,
                    onNavigateToDetails = onNavigateToDetails
                )
            }
            Tabs.Settings -> {
                SettingsScreen(
                    isNavigationRail = isNavigationRail
                )
            }
            Tabs.About -> {
                AboutScreen(
                    isNavigationRail = isNavigationRail
                )
            }
        }
    }
}
