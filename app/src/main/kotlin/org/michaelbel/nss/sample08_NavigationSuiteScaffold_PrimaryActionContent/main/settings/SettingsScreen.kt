@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)

package org.michaelbel.nss.sample08_NavigationSuiteScaffold_PrimaryActionContent.main.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.michaelbel.nss.AppSettings
import org.michaelbel.nss.FormatAlignCenter
import org.michaelbel.nss.FormatAlignLeft
import org.michaelbel.nss.FormatAlignRight
import org.michaelbel.nss.FormatPaint

@Composable
fun SettingsScreen(
    isNavigationRail: Boolean,
    isNavigationBar: Boolean
) {
    val dynamicColorsEnabled by AppSettings.dynamicColorsFlow.collectAsStateWithLifecycle()
    val primaryActionAlignment by AppSettings.primaryActionAlignmentFlow.collectAsStateWithLifecycle()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val navBarBottom = if (isNavigationRail) WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding() else 0.dp

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text(text = "Settings") },
                colors = TopAppBarDefaults.topAppBarColors(
                    scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer
                ),
                scrollBehavior = scrollBehavior
            )
        },
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets.only(WindowInsetsSides.Horizontal)
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentPadding = PaddingValues(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp,
                bottom = if (isNavigationRail) navBarBottom else 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(ListItemDefaults.SegmentedGap)
        ) {
            item {
                ListItem(
                    onClick = AppSettings::toggleDynamicColors,
                    leadingContent = {
                        Icon(
                            imageVector = FormatPaint,
                            contentDescription = null
                        )
                    },
                    trailingContent = {
                        Switch(
                            checked = dynamicColorsEnabled,
                            onCheckedChange = null
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "Dynamic Colors") }
            }
            if (isNavigationBar) {
                item {
                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )
                }
                item {
                    SegmentedListItem(
                        selected = primaryActionAlignment == Alignment.Start,
                        onClick = { AppSettings.setPrimaryActionAlignment(Alignment.Start) },
                        shapes = ListItemDefaults.segmentedShapes(index = 0, count = 3),
                        leadingContent = {
                            Icon(
                                imageVector = FormatAlignLeft,
                                contentDescription = null
                            )
                        },
                        trailingContent = {
                            RadioButton(
                                selected = primaryActionAlignment == Alignment.Start,
                                onClick = null
                            )
                        },
                        colors = ListItemDefaults.segmentedColors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                        )
                    ) { Text(text = "Alignment.Start") }
                }
                item {
                    SegmentedListItem(
                        selected = primaryActionAlignment == Alignment.CenterHorizontally,
                        onClick = { AppSettings.setPrimaryActionAlignment(Alignment.CenterHorizontally) },
                        shapes = ListItemDefaults.segmentedShapes(index = 1, count = 3),
                        leadingContent = {
                            Icon(
                                imageVector = FormatAlignCenter,
                                contentDescription = null
                            )
                        },
                        trailingContent = {
                            RadioButton(
                                selected = primaryActionAlignment == Alignment.CenterHorizontally,
                                onClick = null
                            )
                        },
                        colors = ListItemDefaults.segmentedColors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                        )
                    ) { Text(text = "Alignment.Center") }
                }
                item {
                    SegmentedListItem(
                        selected = primaryActionAlignment == Alignment.End,
                        onClick = { AppSettings.setPrimaryActionAlignment(Alignment.End) },
                        shapes = ListItemDefaults.segmentedShapes(index = 2, count = 3),
                        leadingContent = {
                            Icon(
                                imageVector = FormatAlignRight,
                                contentDescription = null
                            )
                        },
                        trailingContent = {
                            RadioButton(
                                selected = primaryActionAlignment == Alignment.End,
                                onClick = null
                            )
                        },
                        colors = ListItemDefaults.segmentedColors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                        )
                    ) { Text(text = "Alignment.End") }
                }
            }
        }
    }
}
