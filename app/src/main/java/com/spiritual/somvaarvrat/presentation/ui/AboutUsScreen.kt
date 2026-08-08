package com.spiritual.somvaarvrat.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.spiritual.somvaarvrat.R
import com.spiritual.somvaarvrat.presentation.components.CenterAlignTopBar
import com.spiritual.somvaarvrat.utils.TrackScreen

@Composable
fun AboutUsScreen(onBackPress: () -> Unit) {

    TrackScreen("AboutUsScreen")
    val topBarGradient = Brush.verticalGradient(
        listOf(
            Color(0xFFFF8C00),
            Color(0xFFFFA726),
            Color(0xFFFFB74D)
        )
    )

    val backgroundGradient = Brush.verticalGradient(
        listOf(
            Color(0xFFFFF3E0),
            Color(0xFFFFE0B2),
            Color(0xFFFFCC80)
        )
    )

    Scaffold(
        topBar = {
            CenterAlignTopBar(
                title = "About Us",
                gradientBrush = topBarGradient,
                onBack = { onBackPress() }
            )
        },
        containerColor = Color.Transparent
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundGradient)
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {

            // 🌟 HEADER CARD
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .padding(16.dp)
                    .shadow(12.dp, RoundedCornerShape(24.dp))
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(Color(0xFFFF9800), Color(0xFFFFB74D))
                        ),
                        shape = RoundedCornerShape(24.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_app_logo),
                        contentDescription = null,
                        modifier = Modifier.size(120.dp),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Somvar Vrat Katha",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Text(
                        text = "🕉️ शिव भक्ति ऐप 🕉️",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // 📦 INFO SECTION CARD
            AboutCard(
                icon = Icons.Default.Info,
                title = "About App",
                text = "इस ऐप में सोमवार व्रत विधि, कथा, आरती और शिव भक्ति सामग्री दी गई है।"
            )

            AboutCard(
                icon = Icons.Default.Star,
                title = "Features",
                text = "• Offline Access\n• Clean UI\n• Easy Navigation\n• Hindi Content"
            )

            AboutCard(
                icon = Icons.Default.Favorite,
                title = "Our Mission",
                text = "भगवान शिव की भक्ति को सरल और सुंदर रूप में सभी तक पहुँचाना।"
            )

            Spacer(modifier = Modifier.height(20.dp))

            // 🙏 FOOTER
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "🔱 Made with devotion in India 🔱",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF6D4C41)
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Version 1.0.0",
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun AboutCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    text: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF8E1)
        ),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {

        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color(0xFFFF9800),
                modifier = Modifier.size(30.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {

                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFBF360C)
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = text,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    color = Color(0xFF4E342E)
                )
            }
        }
    }
}