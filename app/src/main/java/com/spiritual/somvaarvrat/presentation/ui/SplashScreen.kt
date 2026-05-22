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
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    // Entry Animation
    val alpha = remember { Animatable(0f) }

    // Infinite Zoom Animation
    val infiniteTransition = rememberInfiniteTransition(label = "zoom")

    val logoScale = infiniteTransition.animateFloat(
        initialValue = 0.92f,
        targetValue = 1.08f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1800,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "logoScale"
    )

    // Glow Animation
    val glowScale = infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.3f,
        animationSpec = infiniteRepeatable(
            animation = tween(2200),
            repeatMode = RepeatMode.Reverse
        ),
        label = "glow"
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
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF031B34),
                        Color(0xFF0D47A1),
                        Color(0xFF1565C0),
                        Color(0xFF42A5F5)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {

        // Background Spiritual Glow
        Box(
            modifier = Modifier
                .size(260.dp)
                .scale(glowScale.value)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0x55FFFFFF),
                            Color.Transparent
                        )
                    ),
                    shape = CircleShape
                )
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // Animated Shiva Logo
            Image(
                painter = painterResource(id = R.drawable.ic_app_logo),
                contentDescription = "Shiva Logo",
                modifier = Modifier
                    .size(180.dp)
                    .scale(logoScale.value)
                    .alpha(alpha.value),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "सोमवार व्रत कथा",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.alpha(alpha.value)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "ॐ नमः शिवाय 🙏",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFFFD54F),
                modifier = Modifier.alpha(alpha.value)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "भगवान शिव की कृपा सदा बनी रहे",
                fontSize = 16.sp,
                color = Color(0xFFE3F2FD),
                textAlign = TextAlign.Center,
                modifier = Modifier.alpha(alpha.value)
            )
        }
    }
}