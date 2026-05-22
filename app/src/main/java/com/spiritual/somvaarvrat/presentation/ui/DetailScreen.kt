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
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.spiritual.somvaarvrat.presentation.components.CenterAlignTopBar

@Composable
fun DetailScreen(
    navController: NavController,
    title: String,
    content: String
) {

    val topBarGradient = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFF0D47A1),
            Color(0xFF1565C0),
            Color(0xFF42A5F5)
        )
    )

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

        containerColor = Color(0xFFF4F8FF)

    ) { innerPadding ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFF5F9FF),
                                Color(0xFFE8F1FF)
                            )
                        )
                    )
                    .verticalScroll(rememberScrollState())
                    .padding(18.dp)
            ) {

                // Main Spiritual Content Container
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    // Background Glow
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(520.dp)
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color(0x220D47A1),
                                        Color.Transparent
                                    )
                                ),
                                shape = RoundedCornerShape(30.dp)
                            )
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = Color.White.copy(alpha = 0.96f),
                                shape = RoundedCornerShape(30.dp)
                            )
                            .padding(
                                horizontal = 24.dp,
                                vertical = 30.dp
                            )
                    ) {

                        // Top Om Icon
                        Text(
                            text = "🕉️",
                            fontSize = 60.sp,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        // Spiritual Divider
                        Text(
                            text = "༺═══━━━✦━━━═══༻",
                            color = Color(0xFF1565C0),
                            fontSize = 18.sp,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(18.dp))

                        // Title
                        Text(
                            text = title,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0D47A1),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "ॐ त्र्यम्बकं यजामहे 🙏",
                            fontSize = 18.sp,
                            color = Color(0xFFFF9800),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(26.dp))

                        // Decorative Line
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(
                                    Brush.horizontalGradient(
                                        colors = listOf(
                                            Color.Transparent,
                                            Color(0xFF64B5F6),
                                            Color.Transparent
                                        )
                                    )
                                )
                        )

                        Spacer(modifier = Modifier.height(28.dp))

                        // Main Content
                        Text(
                            text = content,
                            color = Color(0xFF5D4037),
                            fontSize = 21.sp,
                            lineHeight = 25.sp,
                            letterSpacing = 0.5.sp,
                            textAlign = TextAlign.Justify,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Medium
                            ),

                            modifier = Modifier
                                .fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(34.dp))

                        // Bottom Blessing
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "🔱",
                                fontSize = 36.sp
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = "हर हर महादेव",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF0D47A1)
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = "भगवान शिव आपकी सभी मनोकामनाएं पूर्ण करें 🙏",
                                fontSize = 15.sp,
                                color = Color(0xFF546E7A),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))
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

        content =
            """
            प्रातः काल स्नान करके स्वच्छ वस्त्र धारण करें।

            भगवान शिव का जल, दूध और बेलपत्र से अभिषेक करें।

            शिव मंत्र "ॐ नमः शिवाय" का जाप करें।

            सोमवार व्रत कथा का श्रद्धापूर्वक पाठ करें।

            शाम को शिव आरती करें और प्रसाद वितरित करें।

            भगवान शिव की कृपा से जीवन में सुख, शांति और समृद्धि आती है।

            हर सोमवार भगवान शिव का व्रत रखने से मन शांत रहता है
            और जीवन में सकारात्मक ऊर्जा का संचार होता है।

            हर हर महादेव 🔱
            """.trimIndent()
    )
}