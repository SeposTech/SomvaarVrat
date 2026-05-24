package com.spiritual.somvaarvrat.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.spiritual.somvaarvrat.R
import com.spiritual.somvaarvrat.presentation.components.CenterAlignTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutUsScreen(navController: NavController) {

    val topBarGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFE68A1F),
            Color(0xFFE68A1F),
            Color(0xFFC96A12)
        )
    )

    Scaffold(

        topBar = {

            CenterAlignTopBar(
                title = "About Us",
                gradientBrush = topBarGradient,
                onBack = {
                    navController.popBackStack()
                }
            )
        }

    ) { paddingValues ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = Color(0xFFFFF8F0)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {

                // Header Section
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(260.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFFFF9800),
                                    Color(0xFFFFB74D)
                                )
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.ic_app_logo),
                            contentDescription = "App Logo",
                            modifier = Modifier.size(130.dp),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.height(18.dp))

                        Text(
                            text = "Somvar Vrat Katha",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "भगवान शिव भक्तों के लिए",
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {

                    RowItem(
                        icon = Icons.Default.Info,
                        title = "About App",
                        description = "यह ऐप सोमवार व्रत कथा, शिव आरती, शिव मंत्र और शिव चालीसा पढ़ने के लिए बनाई गई है।"
                    )

                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 22.dp),
                        color = Color.LightGray
                    )

                    RowItem(
                        icon = Icons.Default.Star,
                        title = "Features",
                        description = "• सुंदर UI\n• आसान नेविगेशन\n• ऑफलाइन सामग्री\n• हिंदी भाषा समर्थन"
                    )

                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 22.dp),
                        color = Color.LightGray
                    )

                    RowItem(
                        icon = Icons.Default.Favorite,
                        title = "Our Mission",
                        description = "भगवान शिव की भक्ति को सभी भक्तों तक सरल और सुंदर रूप में पहुँचाना।"
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                // Footer
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),

                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Made with ❤️ in India",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF6D4C41)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Version 1.0.0",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "© 2026 Somvar Vrat Katha",
                        fontSize = 15.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
        }
    }
}

@Composable
fun RowItem(
    icon: ImageVector,
    title: String,
    description: String
) {

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFFFF9800),
            modifier = Modifier.size(34.dp)
        )

        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        ) {

            Text(
                text = title,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFBF360C)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = description,
                fontSize = 17.sp,
                lineHeight = 28.sp,
                color = Color(0xFF4E342E)
            )
        }
    }
}