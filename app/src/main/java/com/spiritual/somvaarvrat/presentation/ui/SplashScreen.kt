package com.spiritual.somvaarvrat.presentation.ui

import android.app.Activity
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability
import com.spiritual.somvaarvrat.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.tasks.await

@Composable
fun SplashScreen(
    navController: NavController,
    appUpdateManager: AppUpdateManager
) {

    val context = LocalContext.current
    val activity = context as? Activity

    // Fade Animation
    val alpha = remember { Animatable(0f) }

    // Zoom Animation
    val infiniteTransition = rememberInfiniteTransition(label = "zoom")

    val imageScale = infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 3000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "imageScale"
    )

    LaunchedEffect(Unit) {

        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(2000)
        )

        try {

            val appUpdateInfo = appUpdateManager.appUpdateInfo.await()

            if (
                appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE &&
                appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)
            ) {

                activity?.let {

                    appUpdateManager.startUpdateFlowForResult(
                        appUpdateInfo,
                        AppUpdateType.IMMEDIATE,
                        it,
                        100
                    )
                }

            } else {

                delay(3500)

                navController.navigate("Home") {
                    popUpTo("Splash") { inclusive = true }
                }
            }

        } catch (e: Exception) {

            delay(3500)

            navController.navigate("Home") {
                popUpTo("Splash") { inclusive = true }
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // Full Splash Background Image
        Image(
            painter = painterResource(id = R.drawable.bg_bhole),
            contentDescription = "Somvar Vrat Splash",
            modifier = Modifier
                .fillMaxSize()
                .scale(imageScale.value)
                .alpha(alpha.value),
            contentScale = ContentScale.FillBounds
        )
    }
}