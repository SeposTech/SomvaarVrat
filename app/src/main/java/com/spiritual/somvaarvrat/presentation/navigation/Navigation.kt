package com.spiritual.somvaarvrat.presentation.navigation

import android.app.Activity
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.android.play.core.appupdate.AppUpdateManager
import com.spiritual.somvaarvrat.R
import com.spiritual.somvaarvrat.presentation.ui.AartiScreen
import com.spiritual.somvaarvrat.presentation.ui.AboutUsScreen
import com.spiritual.somvaarvrat.presentation.ui.DetailScreen
import com.spiritual.somvaarvrat.presentation.ui.HomeScreen
import com.spiritual.somvaarvrat.presentation.ui.SplashScreen

@Composable
fun Navigation(appUpdateManager: AppUpdateManager) {

    val navController = rememberNavController()
    val context = LocalContext.current
    val activity = context as Activity

    NavHost(
        navController = navController,
        startDestination = "Splash"
    ) {

        composable(
            route = "Splash",

            exitTransition = {

                fadeOut(
                    animationSpec = tween(500)
                ) + scaleOut(
                    targetScale = 1.02f,
                    animationSpec = tween(500)
                )
            }

        ) {

            SplashScreen(
                navController = navController,
                appUpdateManager = appUpdateManager
            )
        }

        composable(
            route = "Home",

            enterTransition = {

                fadeIn(
                    animationSpec = tween(650)
                ) + scaleIn(
                    initialScale = 0.98f,
                    animationSpec = tween(650)
                )
            }

        ) {

            HomeScreen(navController = navController)
        }

        composable(
            route = "detail/{title}/{resId}",
            arguments = listOf(
                navArgument("title") {
                    type = NavType.StringType
                },
                navArgument("resId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val title = backStackEntry.arguments?.getString("title") ?: ""

            val resId = backStackEntry.arguments?.getInt("resId") ?: 0

            DetailScreen(
                navController = navController,
                title = title,
                resId = resId
            )
        }

        composable(route = "about") {
            AboutUsScreen(navController = navController)
        }

        composable(
            route = "aarti/{title}/{resId}",
            arguments = listOf(
                navArgument("title") {
                    type = NavType.StringType
                },
                navArgument("resId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val title = backStackEntry.arguments?.getString("title") ?: ""
            val resId = backStackEntry.arguments?.getInt("resId") ?: 0

            AartiScreen(
                navController = navController,
                title = title,
                resId = resId
            )
        }
    }
}