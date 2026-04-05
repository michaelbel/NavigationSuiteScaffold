@file:OptIn(ExperimentalMaterial3AdaptiveApi::class)

package org.michaelbel.nss.sample7.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.ShortNavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.WideNavigationRailItem
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
import org.michaelbel.nss.sample7.main.about.AboutScreen
import org.michaelbel.nss.sample7.main.home.HomeScreen
import org.michaelbel.nss.sample7.main.settings.SettingsScreen
import org.michaelbel.nss.Tabs

@Composable
fun MainScreen(
    onNavigateToDetails: (Int) -> Unit
) {
    var selectedTab by rememberSaveable(stateSaver = Tabs.Saver) { mutableStateOf(Tabs.Home) }

    val windowAdaptiveInfo = currentWindowAdaptiveInfo(supportLargeAndXLargeWidth = true)
    val windowDpSize = currentWindowDpSize()

    val navigationSuiteType = when {
        windowDpSize.width >= 1200.dp -> NavigationSuiteType.WideNavigationRailExpanded
        else -> NavigationSuiteScaffoldDefaults.navigationSuiteType(windowAdaptiveInfo)
    }
    val isSideNavigation = windowDpSize.width >= 840.dp

    NavigationSuiteScaffold(
        navigationItems = {
            when (navigationSuiteType) {
                NavigationSuiteType.ShortNavigationBarCompact,
                NavigationSuiteType.ShortNavigationBarMedium -> {
                    ShortNavigationBarItem(
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

                    ShortNavigationBarItem(
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

                    ShortNavigationBarItem(
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
                else -> {
                    WideNavigationRailItem(
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
                        },
                        railExpanded = navigationSuiteType == NavigationSuiteType.WideNavigationRailExpanded
                    )

                    WideNavigationRailItem(
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
                        },
                        railExpanded = navigationSuiteType == NavigationSuiteType.WideNavigationRailExpanded
                    )

                    WideNavigationRailItem(
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
                        },
                        railExpanded = navigationSuiteType == NavigationSuiteType.WideNavigationRailExpanded
                    )
                }
            }

            /*ShortNavigationBar {
                ShortNavigationBarItem(
                    selected = selectedTab == TabNavigation.Home,
                    onClick = { selectedTab = TabNavigation.Home },
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

                ShortNavigationBarItem(
                    selected = selectedTab == TabNavigation.Settings,
                    onClick = { selectedTab = TabNavigation.Settings },
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

                ShortNavigationBarItem(
                    selected = selectedTab == TabNavigation.About,
                    onClick = { selectedTab = TabNavigation.About },
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
            }*/

            /*ShortNavigationBar {
                ShortNavigationBarItem(
                    selected = selectedTab == TabNavigation.Home,
                    onClick = { selectedTab = TabNavigation.Home },
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
                    },
                    iconPosition = NavigationItemIconPosition.Start
                )

                ShortNavigationBarItem(
                    selected = selectedTab == TabNavigation.Settings,
                    onClick = { selectedTab = TabNavigation.Settings },
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
                    },
                    iconPosition = NavigationItemIconPosition.Start
                )

                ShortNavigationBarItem(
                    selected = selectedTab == TabNavigation.About,
                    onClick = { selectedTab = TabNavigation.About },
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
                    },
                    iconPosition = NavigationItemIconPosition.Start
                )
            }*/

            /*WideNavigationRail {
                WideNavigationRailItem(
                    selected = selectedTab == TabNavigation.Home,
                    onClick = { selectedTab = TabNavigation.Home },
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
                    },
                    railExpanded = false
                )

                WideNavigationRailItem(
                    selected = selectedTab == TabNavigation.Settings,
                    onClick = { selectedTab = TabNavigation.Settings },
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
                    },
                    railExpanded = false
                )

                WideNavigationRailItem(
                    selected = selectedTab == TabNavigation.About,
                    onClick = { selectedTab = TabNavigation.About },
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
                    },
                    railExpanded = false
                )
            }*/

            /*WideNavigationRail(
                modifier = Modifier.fillMaxWidth()
            ) {
                WideNavigationRailItem(
                    selected = selectedTab == TabNavigation.Home,
                    onClick = { selectedTab = TabNavigation.Home },
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
                    },
                    railExpanded = true
                )

                WideNavigationRailItem(
                    selected = selectedTab == TabNavigation.Settings,
                    onClick = { selectedTab = TabNavigation.Settings },
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
                    },
                    railExpanded = true
                )

                WideNavigationRailItem(
                    selected = selectedTab == TabNavigation.About,
                    onClick = { selectedTab = TabNavigation.About },
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
                    },
                    railExpanded = true
                )
            }*/

            /*NavigationRail {
                NavigationRailItem(
                    selected = selectedTab == TabNavigation.Home,
                    onClick = { selectedTab = TabNavigation.Home },
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
                    selected = selectedTab == TabNavigation.Settings,
                    onClick = { selectedTab = TabNavigation.Settings },
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
                    selected = selectedTab == TabNavigation.About,
                    onClick = { selectedTab = TabNavigation.About },
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
            }*/

            /*NavigationRail {
                NavigationRailItem(
                    selected = selectedTab == TabNavigation.Home,
                    onClick = { selectedTab = TabNavigation.Home },
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
                    },
                    alwaysShowLabel = false
                )

                NavigationRailItem(
                    selected = selectedTab == TabNavigation.Settings,
                    onClick = { selectedTab = TabNavigation.Settings },
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
                    },
                    alwaysShowLabel = false
                )

                NavigationRailItem(
                    selected = selectedTab == TabNavigation.About,
                    onClick = { selectedTab = TabNavigation.About },
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
                    },
                    alwaysShowLabel = false
                )
            }*/

            /*ModalDrawerSheet {
                NavigationDrawerItem(
                    selected = selectedTab == TabNavigation.Home,
                    onClick = { selectedTab = TabNavigation.Home },
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
                    selected = selectedTab == TabNavigation.Settings,
                    onClick = { selectedTab = TabNavigation.Settings },
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
                    selected = selectedTab == TabNavigation.About,
                    onClick = { selectedTab = TabNavigation.About },
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
            }*/

            /*DismissibleDrawerSheet {
                NavigationDrawerItem(
                    selected = selectedTab == TabNavigation.Home,
                    onClick = { selectedTab = TabNavigation.Home },
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
                    selected = selectedTab == TabNavigation.Settings,
                    onClick = { selectedTab = TabNavigation.Settings },
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
                    selected = selectedTab == TabNavigation.About,
                    onClick = { selectedTab = TabNavigation.About },
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
            }*/

            /*PermanentDrawerSheet {
                NavigationDrawerItem(
                    selected = selectedTab == TabNavigation.Home,
                    onClick = { selectedTab = TabNavigation.Home },
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
                    selected = selectedTab == TabNavigation.Settings,
                    onClick = { selectedTab = TabNavigation.Settings },
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
                    selected = selectedTab == TabNavigation.About,
                    onClick = { selectedTab = TabNavigation.About },
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
            }*/
        },
        modifier = Modifier.fillMaxSize(),
        navigationSuiteType = navigationSuiteType
    ) {
        when (selectedTab) {
            Tabs.Home -> {
                HomeScreen(
                    isSideNavigation = isSideNavigation,
                    onNavigateToDetails = onNavigateToDetails
                )
            }
            Tabs.Settings -> {
                SettingsScreen(
                    isSideNavigation = isSideNavigation
                )
            }
            Tabs.About -> {
                AboutScreen(
                    isSideNavigation = isSideNavigation
                )
            }
        }
    }
}
