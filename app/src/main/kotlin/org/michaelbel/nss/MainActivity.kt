package org.michaelbel.nss

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import org.michaelbel.nss.sample1_Scaffold_BottomBar.Sample1App
import org.michaelbel.nss.sample2_NavigationSuiteScaffold_BottomBar.Sample2App
import org.michaelbel.nss.sample3_NavigationSuiteScaffold_BottomBar.Sample3App
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
                val index = 0
                when (index) {
                    0 -> Sample1App()
                    1 -> Sample2App()
                    2 -> Sample3App()
                    3 -> Sample4App()
                    4 -> Sample5App()
                    5 -> Sample6App()
                    6 -> NavigationSuiteScaffoldSample()
                }
            }
        }
    }
}
