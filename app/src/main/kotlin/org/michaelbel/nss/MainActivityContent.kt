package org.michaelbel.nss

import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.plus
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import org.michaelbel.nss.sample01_Scaffold_BottomBar.Sample01App
import org.michaelbel.nss.sample02_NavigationSuiteScaffold_NavigationBar.Sample02App
import org.michaelbel.nss.sample03_NavigationSuiteScaffold_NavigationRail.Sample03App
import org.michaelbel.nss.sample04_NavigationSuiteScaffold_NavigationRail_NoLabels.Sample04App
import org.michaelbel.nss.sample05_NavigationSuiteScaffold_NavigationRail_Expanded.Sample05App
import org.michaelbel.nss.sample06_NavigationSuiteScaffold_NavigationRail_VerticalArrangement.Sample06App
import org.michaelbel.nss.sample07_NavigationSuiteScaffold_NavigationRail_Expanded_State.Sample07App
import org.michaelbel.nss.sample08_NavigationSuiteScaffold_PrimaryActionContent.Sample08App
import org.michaelbel.nss.sample09_NavigationSuiteScaffold_Colors.Sample09App
import org.michaelbel.nss.sample10_NavigationSuiteScaffold_NavigationSuite.Sample10App
import org.michaelbel.nss.sample11_NavigationSuiteScaffold_NavigationSuiteScaffoldLayout.Sample11App

private data object Home
private data object Sample01
private data object Sample02
private data object Sample03
private data object Sample04
private data object Sample05
private data object Sample06
private data object Sample07
private data object Sample08
private data object Sample09
private data object Sample10
private data object Sample11

@Composable
fun MainActivityContent() {
    val backStack = remember { mutableStateListOf<Any>(Home) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        popTransitionSpec = { fadeIn() togetherWith fadeOut() using SizeTransform(clip = false) },
        predictivePopTransitionSpec = { fadeIn() togetherWith fadeOut() using SizeTransform(clip = false) },
        entryProvider = entryProvider {
            entry<Home> {
                val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "NavigationSuiteScaffold") },
                            colors = TopAppBarDefaults.topAppBarColors(
                                scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer
                            ),
                            scrollBehavior = scrollBehavior
                        )
                    }
                ) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = innerPadding + PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(ListItemDefaults.SegmentedGap)
                    ) {
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample01) },
                                shapes = ListItemDefaults.segmentedShapes(index = 0, count = 1),
                                overlineContent = { Text(text = "Sample 01") },
                                colors = ListItemDefaults.colors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                )
                            ) { Text(text = "Classic Scaffold BottomBar") }
                        }
                        item {
                            Spacer(
                                modifier = Modifier.height(12.dp)
                            )
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample02) },
                                shapes = ListItemDefaults.segmentedShapes(index = 0, count = 10),
                                overlineContent = { Text(text = "Sample 02") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                )
                            ) { Text(text = "NavigationSuiteScaffold NavigationBar") }
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample03) },
                                shapes = ListItemDefaults.segmentedShapes(index = 1, count = 10),
                                overlineContent = { Text(text = "Sample 03") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                )
                            ) { Text(text = "NavigationSuiteScaffold NavigationRail") }
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample04) },
                                shapes = ListItemDefaults.segmentedShapes(index = 2, count = 10),
                                overlineContent = { Text(text = "Sample 04") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                )
                            ) { Text(text = "NavigationRail NoLabels") }
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample05) },
                                shapes = ListItemDefaults.segmentedShapes(index = 3, count = 10),
                                overlineContent = { Text(text = "Sample 05") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                )
                            ) { Text(text = "NavigationRail Expanded") }
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample06) },
                                shapes = ListItemDefaults.segmentedShapes(index = 4, count = 10),
                                overlineContent = { Text(text = "Sample 06") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                )
                            ) { Text(text = "NavigationRail VerticalArrangement") }
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample07) },
                                shapes = ListItemDefaults.segmentedShapes(index = 5, count = 10),
                                overlineContent = { Text(text = "Sample 07") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                )
                            ) { Text(text = "NavigationRail Expanded State") }
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample08) },
                                shapes = ListItemDefaults.segmentedShapes(index = 6, count = 10),
                                overlineContent = { Text(text = "Sample 08") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                )
                            ) { Text(text = "PrimaryActionContent") }
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample09) },
                                shapes = ListItemDefaults.segmentedShapes(index = 7, count = 10),
                                overlineContent = { Text(text = "Sample 09") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                )
                            ) { Text(text = "Colors") }
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample10) },
                                shapes = ListItemDefaults.segmentedShapes(index = 8, count = 10),
                                overlineContent = { Text(text = "Sample 10") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                )
                            ) { Text(text = "NavigationSuite") }
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample11) },
                                shapes = ListItemDefaults.segmentedShapes(index = 9, count = 10),
                                overlineContent = { Text(text = "Sample 11") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                )
                            ) { Text(text = "NavigationSuiteScaffoldLayout") }
                        }
                    }
                }
            }
            entry<Sample01> { Sample01App() }
            entry<Sample02> { Sample02App() }
            entry<Sample03> { Sample03App() }
            entry<Sample04> { Sample04App() }
            entry<Sample05> { Sample05App() }
            entry<Sample06> { Sample06App() }
            entry<Sample07> { Sample07App() }
            entry<Sample08> { Sample08App() }
            entry<Sample09> { Sample09App() }
            entry<Sample10> { Sample10App() }
            entry<Sample11> { Sample11App() }
        }
    )
}
