package com.spiritual.somvaarvrat.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.spiritual.somvaarvrat.presentation.components.CenterAlignTopBar

@Composable
fun AartiScreen(
    navController: NavController,
    title: String,
    resId: Int
) {

    val context = LocalContext.current
    val scrollState = rememberScrollState()

    val content = remember(resId) {
        context.resources.openRawResource(resId)
            .bufferedReader()
            .use { it.readText() }
    }

    val topBarGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFF8C00),
            Color(0xFFFFA726),
            Color(0xFFFFB74D)
        )
    )

    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFF3E0),
            Color(0xFFFFE0B2),
            Color(0xFFFFCC80)
        )
    )

    Scaffold(
        topBar = {
            CenterAlignTopBar(
                title = title,
                gradientBrush = topBarGradient,
                onBack = { navController.popBackStack() }
            )
        },
        containerColor = Color.Transparent
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundGradient)
                .padding(innerPadding)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(horizontal = 18.dp, vertical = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(16.dp))

                // 🕉️ Header
                Text(
                    text = "🕉️ ─── $title ─── 🕉️",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF6D3B00),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(24.dp))

                // 📖 Content (NO CARD, DIRECT TEXT)
                SelectionContainer {
                    Text(
                        text = content,
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Serif,
                        lineHeight = 34.sp,
                        color = Color(0xFF3E2723),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(60.dp))

                // 🙏 Footer
                Text(
                    text = "🔔 हर हर महादेव 🔔",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF8B4513)
                )

                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}