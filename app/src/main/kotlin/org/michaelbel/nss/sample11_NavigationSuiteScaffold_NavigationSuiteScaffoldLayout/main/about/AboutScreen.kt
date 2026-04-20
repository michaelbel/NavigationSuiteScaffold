@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)

package org.michaelbel.nss.sample11_NavigationSuiteScaffold_NavigationSuiteScaffoldLayout.main.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import org.michaelbel.nss.Github
import org.michaelbel.nss.Telegram

@Composable
fun AboutScreen() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val uriHandler = LocalUriHandler.current

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text(text = "About") },
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
                bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
            ),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            item {
                SegmentedListItem(
                    onClick = { uriHandler.openUri("https://github.com/michaelbel") },
                    shapes = ListItemDefaults.segmentedShapes(index = 0, count = 2),
                    leadingContent = {
                        Icon(
                            imageVector = Github,
                            contentDescription = null
                        )
                    },
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "Star on GitHub") }
            }
            item {
                SegmentedListItem(
                    onClick = { uriHandler.openUri("https://t.me/android_career") },
                    shapes = ListItemDefaults.segmentedShapes(index = 1, count = 2),
                    leadingContent = {
                        Icon(
                            imageVector = Telegram,
                            contentDescription = null
                        )
                    },
                    colors = ListItemDefaults.segmentedColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                ) { Text(text = "Telegram Channel") }
            }
        }
    }
}
