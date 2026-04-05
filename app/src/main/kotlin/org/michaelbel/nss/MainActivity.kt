package org.michaelbel.nss

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import org.michaelbel.nss.sample01_Scaffold_BottomBar.Sample01App
import org.michaelbel.nss.sample02_NavigationSuiteScaffold_BottomBar.Sample02App
import org.michaelbel.nss.sample4_NavigationSuiteScaffold_NavigationRail.Sample4App
import org.michaelbel.nss.sample5_NavigationSuiteScaffold_NavigationRail.Sample5App
import org.michaelbel.nss.sample6_NavigationSuiteScaffold_NavigationRailExpanded.Sample6App

class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                val index = 2
                when (index) {
                    0 -> Sample01App()
                    1 -> Sample02App()

                    2 -> Sample4App()
                    4 -> Sample5App()
                    5 -> Sample6App()
                    6 -> NavigationSuiteScaffoldSample()
                }
            }
        }
    }
}
