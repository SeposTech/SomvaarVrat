package com.spiritual.somvaarvrat.presentation.ui

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.spiritual.somvaarvrat.data.repository.model.ShivAartiModel
import com.spiritual.somvaarvrat.presentation.components.CenterAlignTopBar
import com.spiritual.somvaarvrat.presentation.viewmodel.ShivAartiViewModel
import com.spiritual.somvaarvrat.ui.theme.SomvaarVratTheme
import androidx.core.net.toUri

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: ShivAartiViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val uiState = viewModel.uiState.collectAsState().value
    var aartiList: List<ShivAartiModel> = emptyList()
    when (uiState) {
        is ShivAartiViewModel.UiState.Loading -> {
            // Show loading indicator or placeholder

        }

        is ShivAartiViewModel.UiState.Success -> {
            // Display the home screen content with the fetched data
            aartiList = uiState.menuList

        }

        is ShivAartiViewModel.UiState.Error -> {
            // Show error message

        }
    }
    val topBarGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFE68A1F),
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

    var selectedBottomItem by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        contentWindowInsets = WindowInsets(0),
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding(),

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
                    onClick = {
                        selectedBottomItem = 0
                        val shareIntent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(
                                Intent.EXTRA_TEXT,
                                "Download this app:\nhttps://play.google.com/store/apps/details?id=com.spiritual.somvaarvrat"
                            )
                        }

                        context.startActivity(
                            Intent.createChooser(shareIntent, "Share App")
                        )

                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Share"
                        )
                    },
                    label = {
                        Text("Share")
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
                    onClick = {
                        selectedBottomItem = 1
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            "market://details?id=com.spiritual.somvaarvrat".toUri()
                        )

                        context.startActivity(intent)
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Rating"
                        )
                    },
                    label = {
                        Text("Rating")
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
                    onClick = {
                        selectedBottomItem = 2
                        navController.navigate("about")
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "About Us"
                        )
                    },
                    label = {
                        Text("About Us")
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

                items(aartiList) { item ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                if (item.title == "🪔 शिव जी आरती") {
                                navController.navigate(
                                    "aarti/${item.title}/${item.resId}"
                                )
                                } else {
                                    navController.navigate(
                                        "detail/${item.title}/${item.resId}"
                                    )
                                }

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

                                Column(
                                    modifier = Modifier.padding(start = 16.dp)
                                ) {

                                    Text(
                                        text = item.title,

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