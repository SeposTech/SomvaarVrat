package com.spiritual.somvaarvrat.presentation.ui

import android.content.Intent
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.spiritual.somvaarvrat.data.repository.model.ShivAartiModel
import com.spiritual.somvaarvrat.presentation.components.CenterAlignTopBar
import com.spiritual.somvaarvrat.presentation.viewmodel.ShivAartiViewModel
import com.spiritual.somvaarvrat.utils.TrackScreen

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: ShivAartiViewModel = hiltViewModel(),
    onBackPress: () -> Unit
) {

    val context = LocalContext.current

    val uiState = viewModel.uiState.collectAsState().value

    var aartiList: List<ShivAartiModel> = emptyList()

    when (uiState) {

        is ShivAartiViewModel.UiState.Success -> {
            aartiList = uiState.menuList
        }

        else -> {}
    }

    var selectedBottomItem by remember {
        mutableIntStateOf(0)
    }

    val topBarGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFE68A1F),
            Color(0xFFE68A1F),
            Color(0xFFC96A12)
        )
    )

    val backgroundColor = Color(0xFFFFD8A8)
    TrackScreen("Home")

    Scaffold(

        modifier = Modifier
            .fillMaxSize(),

        containerColor = Color(0xFFFFFAF5),

        topBar = {

            CenterAlignTopBar(
                title = "सोमवार व्रत 🙏",
                gradientBrush = topBarGradient,
                onBack = {
                    onBackPress()
                }
            )
        },

        bottomBar = {

            NavigationBar(
                containerColor = Color.White,
                tonalElevation = 0.dp
            ) {

                NavigationBarItem(
                    selected = selectedBottomItem == 0,

                    onClick = {
                        selectedBottomItem = 0
                    },

                    icon = {

                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null
                        )
                    },

                    label = {
                        Text("होम")
                    },

                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFFE68A1F),
                        selectedTextColor = Color(0xFFE68A1F),
                        indicatorColor = Color(0xFFFFE5C2),
                        unselectedIconColor = Color.Gray,
                        unselectedTextColor = Color.Gray
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
                            contentDescription = null
                        )
                    },

                    label = {
                        Text("रेटिंग")
                    },

                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFFE68A1F),
                        selectedTextColor = Color(0xFFE68A1F),
                        indicatorColor = Color(0xFFFFE5C2),
                        unselectedIconColor = Color.Gray,
                        unselectedTextColor = Color.Gray
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
                            contentDescription = null
                        )
                    },

                    label = {
                        Text("जानकारी")
                    },

                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFFE68A1F),
                        selectedTextColor = Color(0xFFE68A1F),
                        indicatorColor = Color(0xFFFFE5C2),
                        unselectedIconColor = Color.Gray,
                        unselectedTextColor = Color.Gray
                    )
                )
            }
        }

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFFAF5))
                .padding(innerPadding)
        ) {

            Spacer(modifier = Modifier.height(10.dp))

            // TOP CARD

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),

                shape = RoundedCornerShape(18.dp),

                colors = CardDefaults.cardColors(
                    containerColor = backgroundColor
                ),

                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color(0xFFF59E0B),
                                    Color(0xFFE67E00)
                                )
                            )
                        )
                        .padding(
                            horizontal = 20.dp,
                            vertical = 18.dp
                        ),

                    verticalAlignment = Alignment.CenterVertically,

                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column {

                        Text(
                            text = "ॐ नमः शिवाय",
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "भोलेनाथ की कृपा\nसदैव बनी रहे",
                            color = Color.White.copy(alpha = 0.95f),
                            fontSize = 16.sp,
                            lineHeight = 22.sp
                        )
                    }

                    Text(
                        text = "🔱",
                        fontSize = 55.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "क्या जानना चाहते हैं?",

                modifier = Modifier.padding(horizontal = 18.dp),

                fontSize = 18.sp,

                fontWeight = FontWeight.Bold,

                color = Color(0xFF2E2E2E)
            )

            Spacer(modifier = Modifier.height(14.dp))

            LazyVerticalGrid(

                columns = GridCells.Fixed(2),

                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 14.dp),

                verticalArrangement = Arrangement.spacedBy(14.dp),

                horizontalArrangement = Arrangement.spacedBy(14.dp),

                contentPadding = PaddingValues(bottom = 20.dp)
            ) {

                itemsIndexed(
                    items = aartiList,

                    span = { _, item ->

                        if (item.title.contains("आरती")) {
                            GridItemSpan(2)
                        } else {
                            GridItemSpan(1)
                        }
                    }
                ) { _, item ->

                    val isAartiCard = item.title.contains("आरती")

                    Card(

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(
                                if (isAartiCard) 120.dp else 175.dp
                            )
                            .clickable {

                                if (item.title == "🪔 शिव जी आरती") {

                                    navController.navigate(
                                        "aarti/${item.title}/${item.resId}"
                                    )

                                } else if (item.title.contains("🕉️ पूजा विधि")) {
                                    navController.navigate("pujaVidhi")
                                } else {

                                    navController.navigate(
                                        "detail/${item.title}/${item.resId}"
                                    )
                                }
                            },

                        shape = RoundedCornerShape(18.dp),

                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),

                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 2.dp
                        )
                    ) {

                        if (isAartiCard) {

                            Row(

                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(
                                        horizontal = 18.dp,
                                        vertical = 16.dp
                                    ),

                                verticalAlignment = Alignment.CenterVertically,

                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {

                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Box(
                                        modifier = Modifier
                                            .size(62.dp)
                                            .clip(CircleShape)
                                            .background(Color(0xFFFFF2DE)),

                                        contentAlignment = Alignment.Center
                                    ) {

                                        Text(
                                            text = "🪔",
                                            fontSize = 30.sp
                                        )
                                    }

                                    Column(
                                        modifier = Modifier.padding(start = 14.dp)
                                    ) {

                                        Text(
                                            text = "शिव जी आरती",

                                            fontSize = 20.sp,

                                            fontWeight = FontWeight.Bold,

                                            color = Color(0xFF9C2F12)
                                        )

                                        Spacer(modifier = Modifier.height(6.dp))

                                        Text(
                                            text = "ॐ जय शिव ओंकारा...",

                                            fontSize = 14.sp,

                                            color = Color(0xFF8D6E63)
                                        )
                                    }
                                }

                                Text(
                                    text = "🔱",
                                    fontSize = 36.sp
                                )
                            }

                        } else {

                            Column(

                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(
                                        horizontal = 12.dp,
                                        vertical = 14.dp
                                    ),

                                horizontalAlignment = Alignment.CenterHorizontally,

                                verticalArrangement = Arrangement.Center
                            ) {

                                Box(
                                    modifier = Modifier
                                        .size(56.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFFFFF2DE)),

                                    contentAlignment = Alignment.Center
                                ) {

                                    Text(
                                        text = when {

                                            item.title.contains("पूजा") -> "🪔"

                                            item.title.contains("सोमवार") -> "📿"

                                            item.title.contains("प्रदोष") -> "🌙"

                                            else -> "🔱"
                                        },

                                        fontSize = 28.sp
                                    )
                                }

                                Spacer(modifier = Modifier.height(14.dp))

                                Text(

                                    text = item.title
                                        .replace("🪔", "")
                                        .replace("📿", "")
                                        .replace("🌙", "")
                                        .trim(),

                                    fontSize = 15.sp,

                                    lineHeight = 21.sp,

                                    fontWeight = FontWeight.Bold,

                                    color = Color(0xFF9C2F12),

                                    textAlign = TextAlign.Center,

                                    maxLines = 2,

                                    overflow = TextOverflow.Ellipsis
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(

                                    text = when {

                                        item.title.contains("पूजा") ->
                                            "सरल और संपूर्ण\nपूजा विधि"

                                        item.title.contains("कथा") ->
                                            "सोमवार व्रत की\nपवित्र कथा"

                                        item.title.contains("प्रदोष") ->
                                            "सोम्य प्रदोष व्रत\nकी कथा"

                                        else ->
                                            "भोलेनाथ की कृपा"
                                    },

                                    fontSize = 12.sp,

                                    lineHeight = 18.sp,

                                    color = Color(0xFF8D6E63),

                                    textAlign = TextAlign.Center,

                                    maxLines = 2,

                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}