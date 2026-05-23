package com.spiritual.somvaarvrat.presentation.ui

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.spiritual.somvaarvrat.presentation.components.CenterAlignTopBar
import com.spiritual.somvaarvrat.ui.theme.SomvaarVratTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val topBarGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFF1D6),
            Color(0xFFE68A1F),
            Color(0xFFC96A12)
        )
    )

    val cardGradient = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFFFFF8F0),
            Color(0xFFFFE8CC)
        )
    )

    val menuList = listOf(
        "व्रत विधि",
        "शिव व्रत कथा",
        "शिव आरती",
        "शिव मंत्र",
        "शिव चालीसा",
        "शिव स्तोत्र"
    )

    val contentMap = mapOf(

        "व्रत विधि" to
                """
            प्रातः काल स्नान करके स्वच्छ वस्त्र धारण करें।

            भगवान शिव का जल, दूध और बेलपत्र से अभिषेक करें।

            शिव मंत्र "ॐ नमः शिवाय" का जाप करें।
            """.trimIndent(),

        "शिव व्रत कथा" to
                """
            एक समय की बात है एक भक्त भगवान शिव की पूजा करता था।

            भगवान शिव उसकी भक्ति से प्रसन्न हुए और उसके सभी दुख दूर कर दिए।
            """.trimIndent(),

        "शिव आरती" to
                """
            ॐ जय शिव ओंकारा,
            स्वामी जय शिव ओंकारा।
            """.trimIndent(),

        "शिव मंत्र" to
                """
            ॐ नमः शिवाय 🙏
            """.trimIndent(),

        "शिव चालीसा" to
                """
            जय गणेश गिरिजा सुवन,
            मंगल मूल सुजान।
            """.trimIndent(),

        "शिव स्तोत्र" to
                """
            नमामि शमीशान निर्वाण रूपम्।
            """.trimIndent()
    )

    var selectedBottomItem by remember {
        mutableIntStateOf(0)
    }

    Scaffold(

        modifier = modifier
            .fillMaxSize()
            .safeDrawingPadding(),

        containerColor = Color(0xFFFFFBF5),

        topBar = {

            CenterAlignTopBar(
                title = "सोमवार व्रत 🙏",
                gradientBrush = topBarGradient,
                onBack = {}
            )
        },

        bottomBar = {

            NavigationBar(
                containerColor = Color(0xFFFFF8F0),
                tonalElevation = 8.dp,
                modifier = Modifier.navigationBarsPadding()
            ) {

                val selectedColor = Color(0xFFC96A12)
                val unselectedColor = Color(0xFF8D6E63)

                NavigationBarItem(
                    selected = selectedBottomItem == 0,
                    onClick = { selectedBottomItem = 0 },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home"
                        )
                    },
                    label = {
                        Text("Home")
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = selectedColor,
                        selectedTextColor = selectedColor,
                        unselectedIconColor = unselectedColor,
                        unselectedTextColor = unselectedColor,
                        indicatorColor = Color(0xFFFFE0B2)
                    )
                )

                NavigationBarItem(
                    selected = selectedBottomItem == 1,
                    onClick = { selectedBottomItem = 1 },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.MenuBook,
                            contentDescription = "Katha"
                        )
                    },
                    label = {
                        Text("Katha")
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = selectedColor,
                        selectedTextColor = selectedColor,
                        unselectedIconColor = unselectedColor,
                        unselectedTextColor = unselectedColor,
                        indicatorColor = Color(0xFFFFE0B2)
                    )
                )

                NavigationBarItem(
                    selected = selectedBottomItem == 2,
                    onClick = { selectedBottomItem = 2 },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Book,
                            contentDescription = "Aarti"
                        )
                    },
                    label = {
                        Text("Aarti")
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = selectedColor,
                        selectedTextColor = selectedColor,
                        unselectedIconColor = unselectedColor,
                        unselectedTextColor = unselectedColor,
                        indicatorColor = Color(0xFFFFE0B2)
                    )
                )

                NavigationBarItem(
                    selected = selectedBottomItem == 3,
                    onClick = { selectedBottomItem = 3 },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Bhakti"
                        )
                    },
                    label = {
                        Text("Bhakti")
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = selectedColor,
                        selectedTextColor = selectedColor,
                        unselectedIconColor = unselectedColor,
                        unselectedTextColor = unselectedColor,
                        indicatorColor = Color(0xFFFFE0B2)
                    )
                )
            }
        }

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFFBF5))
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {

            Spacer(modifier = Modifier.height(14.dp))

            // Fixed Welcome Card
            Card(
                modifier = Modifier
                    .fillMaxWidth(),

                shape = RoundedCornerShape(0.dp),

                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                ),

                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color(0xFFFFE0B2),
                                    Color(0xFFE68A1F),
                                    Color(0xFFC96A12)
                                )
                            )
                        )
                        .padding(
                            horizontal = 20.dp,
                            vertical = 16.dp
                        ),

                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "🔱",
                            fontSize = 30.sp
                        )

                        Column(
                            modifier = Modifier.padding(start = 14.dp)
                        ) {

                            Text(
                                text = "ॐ नमः शिवाय",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )

                            Text(
                                text = "भोलेनाथ की कृपा सदैव बनी रहे",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.White.copy(alpha = 0.92f),
                                modifier = Modifier.padding(top = 3.dp)
                            )
                        }
                    }

                    Text(
                        text = "🙏",
                        fontSize = 26.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Scrollable Cards
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(
                    bottom = 28.dp
                )
            ) {

                items(menuList) { item ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(
                                    "detail/${Uri.encode(item)}/${Uri.encode(contentMap[item] ?: "")}"
                                )
                            },

                        shape = RoundedCornerShape(22.dp),

                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 5.dp
                        ),

                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        )
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(cardGradient)
                                .padding(
                                    horizontal = 18.dp,
                                    vertical = 20.dp
                                ),

                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Box(
                                    modifier = Modifier
                                        .background(
                                            color = Color(0xFFFFD8A8),
                                            shape = RoundedCornerShape(16.dp)
                                        )
                                        .padding(14.dp)
                                ) {

                                    Text(
                                        text = when (item) {

                                            "व्रत विधि" -> "📿"
                                            "शिव व्रत कथा" -> "📖"
                                            "शिव आरती" -> "🪔"
                                            "शिव मंत्र" -> "🔱"
                                            "शिव चालीसा" -> "📜"
                                            else -> "🙏"
                                        }
                                    )
                                }

                                Column(
                                    modifier = Modifier.padding(start = 16.dp)
                                ) {

                                    Text(
                                        text = item,

                                        style = MaterialTheme.typography.titleMedium,

                                        color = Color(0xFF5D4037),

                                        fontWeight = FontWeight.Bold
                                    )

                                    Text(
                                        text = "Tap to open",

                                        style = MaterialTheme.typography.bodySmall,

                                        color = Color(0xFF8D6E63),

                                        modifier = Modifier.padding(top = 4.dp)
                                    )
                                }
                            }

                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                                contentDescription = "Forward",
                                tint = Color(0xFFC96A12)
                            )
                        }
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

        HomeScreen(
            navController = rememberNavController()
        )
    }
}