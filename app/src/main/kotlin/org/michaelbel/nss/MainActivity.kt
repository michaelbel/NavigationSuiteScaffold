package org.michaelbel.nss

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import org.michaelbel.nss.step1_Scaffold_BottomBar.Step1App
import org.michaelbel.nss.step2_NavigationSuiteScaffold_BottomBar.Step2App
import org.michaelbel.nss.step3_NavigationSuiteScaffold_BottomBar.Step3App
import org.michaelbel.nss.step4_NavigationSuiteScaffold_NavigationRail.Step4App
import org.michaelbel.nss.step5_NavigationSuiteScaffold_NavigationRail.Step5App
import org.michaelbel.nss.step6_NavigationSuiteScaffold_NavigationRailExpanded.Step6App

class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                val index = 5
                when (index) {
                    0 -> Step1App()
                    1 -> Step2App()
                    2 -> Step3App()
                    3 -> Step4App()
                    4 -> Step5App()
                    5 -> Step6App()
                    6 -> NavigationSuiteScaffoldSample()
                }
            }
        }
    }
}
