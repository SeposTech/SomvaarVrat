package com.spiritual.somvaarvrat.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.spiritual.somvaarvrat.R
import com.spiritual.somvaarvrat.presentation.components.CenterAlignTopBar

@Composable
fun DetailScreen(
    navController: NavController,
    title: String,
    resId: Int
) {
    val context = LocalContext.current
    val content = remember(resId) {
        context.resources.openRawResource(resId)
            .bufferedReader()
            .use { it.readText() }
    }

    val topBarGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFE68A1F),
            Color(0xFFE68A1F),
            Color(0xFFC96A12)
        )
    )

    val backgroundColor = Color(0xFFFFD8A8)

    Scaffold(

        topBar = {

            CenterAlignTopBar(
                title = title,
                gradientBrush = topBarGradient,
                onBack = {
                    navController.popBackStack()
                }
            )
        },

        containerColor = Color(0xFFC96A12)

    ) { innerPadding ->

        // OUTER BORDER
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFFFD180),
                            Color(0xFFC96A12),
                            Color(0xFFFFD180)
                        )
                    )
                )
                .padding(2.dp)
        ) {

            // INNER SCREEN
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(backgroundColor)
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
                    .padding(
                        horizontal = 18.dp,
                        vertical = 18.dp
                    )
            ) {

                // Top Spiritual Line
                Text(
                    text = "🕉️ ━━━━━━━━━ 🔱 ━━━━━━━━━ 🕉️",

                    modifier = Modifier.fillMaxWidth(),

                    textAlign = TextAlign.Center,

                    color = Color(0xFFC96A12),

                    fontSize = 18.sp,

                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Main Content
                Column(

                    modifier = Modifier.fillMaxWidth(),

                    verticalArrangement = Arrangement.spacedBy(18.dp)
                ) {

                    Text(
                        text = content,

                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Medium
                        ),

                        color = Color(0xFF4E342E),

                        fontSize = 24.sp,

                        lineHeight = 38.sp,

                        textAlign = TextAlign.Start,

                        fontFamily = FontFamily.Serif,

                        letterSpacing = 0.3.sp
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Bottom Spiritual Line
                    Text(
                        text = "🕉️ ━━━━━━━━━ 🔱 ━━━━━━━━━ 🕉️",

                        modifier = Modifier.fillMaxWidth(),

                        textAlign = TextAlign.Center,

                        color = Color(0xFFC96A12),

                        fontSize = 18.sp,

                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    // Bottom Blessing
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "🔱",
                            fontSize = 34.sp
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "हर हर महादेव",

                            color = Color(0xFFC96A12),

                            fontSize = 24.sp,

                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "भगवान शिव आपकी सभी मनोकामनाएं पूर्ण करें 🙏",

                            color = Color(0xFF6D4C41),

                            fontSize = 15.sp,

                            textAlign = TextAlign.Center,

                            lineHeight = 24.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(28.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {

    DetailScreen(
        navController = rememberNavController(),

        title = "शिव व्रत विधि",

        resId = R.raw.shiv_aarti
    )
}