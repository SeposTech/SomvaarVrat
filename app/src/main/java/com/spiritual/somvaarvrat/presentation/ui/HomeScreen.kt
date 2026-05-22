package com.spiritual.somvaarvrat.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.spiritual.somvaarvrat.presentation.components.CenterAlignTopBar
import com.spiritual.somvaarvrat.ui.theme.SomvaarVratTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier,navController: NavController) {

    val topBarGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFE3F2FD),
            Color(0xFF64B5F6),
            Color(0xFF0D47A1)
        )
    )

    val headerGradient = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFF0D47A1),
            Color(0xFF1565C0),
            Color(0xFF42A5F5)
        )
    )

    val menuList = listOf(
        "व्रत विधि",
        "शिव व्रत कथा",
        "शिव आरती"
    )

    var selectedBottomItem by remember {
        mutableIntStateOf(0)
    }

    Scaffold(

        topBar = {

            CenterAlignTopBar(
                title = "SomvaarVrat",
                gradientBrush = topBarGradient,
                onBack = {}
            )
        },

        bottomBar = {

            NavigationBar(
                containerColor = Color.White,
                tonalElevation = 8.dp,
                modifier = Modifier.navigationBarsPadding()
            ) {

                NavigationBarItem(
                    selected = selectedBottomItem == 0,
                    onClick = {
                        selectedBottomItem = 0
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home"
                        )
                    },
                    label = {
                        Text(text = "Home")
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF0D47A1),
                        selectedTextColor = Color(0xFF0D47A1),
                        indicatorColor = Color(0xFFE3F2FD)
                    )
                )

                NavigationBarItem(
                    selected = selectedBottomItem == 1,
                    onClick = {
                        selectedBottomItem = 1
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.MenuBook,
                            contentDescription = "Katha"
                        )
                    },
                    label = {
                        Text(text = "Katha")
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF0D47A1),
                        selectedTextColor = Color(0xFF0D47A1),
                        indicatorColor = Color(0xFFE3F2FD)
                    )
                )

                NavigationBarItem(
                    selected = selectedBottomItem == 2,
                    onClick = {
                        selectedBottomItem = 2
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Book,
                            contentDescription = "Aarti"
                        )
                    },
                    label = {
                        Text(text = "Aarti")
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF0D47A1),
                        selectedTextColor = Color(0xFF0D47A1),
                        indicatorColor = Color(0xFFE3F2FD)
                    )
                )

                NavigationBarItem(
                    selected = selectedBottomItem == 3,
                    onClick = {
                        selectedBottomItem = 3
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Bhakti"
                        )
                    },
                    label = {
                        Text(text = "Bhakti")
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF0D47A1),
                        selectedTextColor = Color(0xFF0D47A1),
                        indicatorColor = Color(0xFFE3F2FD)
                    )
                )
            }
        },

        modifier = modifier.fillMaxSize(),
        containerColor = Color(0xFFF5F9FF)

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F9FF))
                .padding(innerPadding)
                .padding(16.dp),

            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // Spiritual Header
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(headerGradient)
                        .padding(
                            horizontal = 20.dp,
                            vertical = 26.dp
                        ),

                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "ॐ नमः शिवाय 🙏",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.White
                    )

                    Text(
                        text = "भोलेनाथ की कृपा\nसदैव बनी रहे ✨",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White.copy(alpha = 0.95f),
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }
            }

            // Menu Cards
            menuList.forEach { item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {

                        },

                    shape = RoundedCornerShape(20.dp),

                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),

                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = 20.dp,
                                vertical = 20.dp
                            ),

                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                text = when (item) {

                                    "व्रत विधि" -> "📿"

                                    "शिव व्रत कथा" -> "📖"

                                    "शिव आरती" -> "🪔"

                                    else -> "🙏"
                                },

                                style = MaterialTheme.typography.headlineSmall
                            )

                            Text(
                                text = item,

                                style = MaterialTheme.typography.titleMedium,

                                color = Color(0xFF0D47A1),

                                modifier = Modifier.padding(start = 14.dp)
                            )
                        }

                        Icon(
                            modifier = modifier.clickable{navController.navigate("detail/${item}")},
                            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                            contentDescription = "Forward",
                            tint = Color(0xFF1565C0)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {

    SomvaarVratTheme {

        HomeScreen(navController = rememberNavController())
    }
}