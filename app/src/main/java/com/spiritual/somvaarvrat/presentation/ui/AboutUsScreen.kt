package com.spiritual.somvaarvrat.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.spiritual.somvaarvrat.R
import com.spiritual.somvaarvrat.presentation.components.CenterAlignTopBar
import com.spiritual.somvaarvrat.utils.TrackScreen


@Composable
fun AboutUsScreen(
    onBackPress: () -> Unit
) {

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
                title = "हमारे बारे में",
                gradientBrush = topBarGradient,
                onBack = {
                    onBackPress()
                }
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
                .padding(bottom = 24.dp)
        ) {

            // ---------------------------------------------------------
            // HEADER
            // ---------------------------------------------------------

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .padding(16.dp)
                    .shadow(
                        elevation = 10.dp,
                        shape = RoundedCornerShape(24.dp)
                    )
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color(0xFFFF9800),
                                Color(0xFFFFB74D)
                            )
                        ),
                        shape = RoundedCornerShape(24.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(
                            id = R.drawable.ic_app_logo
                        ),
                        contentDescription = "App Logo",
                        modifier = Modifier.size(110.dp),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = "Somvar Vrat Katha",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "ॐ नमः शिवाय 🙏",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text = "भगवान शिव की भक्ति को समर्पित",
                        fontSize = 14.sp,
                        color = Color.White.copy(alpha = 0.95f)
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            // ---------------------------------------------------------
            // ABOUT US
            // ---------------------------------------------------------

            AboutCard(
                icon = Icons.Default.Info,
                title = "हमारे बारे में",
                text = """
                    Somvar Vrat Katha ऐप भगवान शिव के भक्तों के लिए
                    एक सरल और श्रद्धापूर्ण प्रयास है।

                    इस ऐप के माध्यम से सोमवार व्रत, भगवान शिव की
                    आराधना और पूजा से जुड़ी आवश्यक धार्मिक सामग्री
                    को एक ही स्थान पर आसानी से पढ़ा जा सकता है।

                    हमारा प्रयास है कि भक्ति और धार्मिक जानकारी
                    आपको सरल, सहज और सुंदर रूप में उपलब्ध हो।
                """.trimIndent()
            )

            // ---------------------------------------------------------
            // CONTENT
            // ---------------------------------------------------------

            AboutCard(
                icon = Icons.Default.Star,
                title = "इस ऐप में क्या मिलेगा",
                text = """
                    🪔 सोमवार व्रत कथा

                    📿 सोमवार व्रत एवं पूजा विधि

                    🔱 भगवान शिव की आरती

                    🌙 प्रदोष व्रत कथा

                    🙏 भगवान शिव से जुड़ी भक्तिमय सामग्री
                """.trimIndent()
            )

            // ---------------------------------------------------------
            // PURPOSE
            // ---------------------------------------------------------

            AboutCard(
                icon = Icons.Default.Favorite,
                title = "हमारा उद्देश्य",
                text = """
                    हमारा उद्देश्य किसी धार्मिक परंपरा को बदलना नहीं,
                    बल्कि उससे जुड़ी जानकारी को सरल रूप में भक्तों
                    तक पहुँचाना है।

                    हम चाहते हैं कि आप अपनी भक्ति और पूजा से जुड़ी
                    सामग्री को कभी भी, कहीं भी आसानी से पढ़ सकें।
                """.trimIndent()
            )

            // ---------------------------------------------------------
            // OUR INITIATIVE
            // ---------------------------------------------------------

            AboutCard(
                icon = Icons.Default.Favorite,
                title = "हमारी छोटी सी पहल",
                text = """
                    यह ऐप श्रद्धा और भक्ति की भावना से बनाया गया
                    एक छोटा सा प्रयास है।

                    यदि इस ऐप के माध्यम से किसी भक्त को सोमवार व्रत,
                    शिव आराधना या पूजा के समय थोड़ी भी सहायता मिलती है,
                    तो हमारा यह प्रयास सार्थक है।

                    हर हर महादेव 🔱
                """.trimIndent()
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            // ---------------------------------------------------------
            // DISCLAIMER
            // ---------------------------------------------------------

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFFFF8E1)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                )
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "अस्वीकरण",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFBF360C)
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text = """
                            यह ऐप धार्मिक एवं आध्यात्मिक जानकारी को
                            सरल रूप में प्रस्तुत करने के उद्देश्य से
                            बनाया गया है।

                            पूजा-पाठ और धार्मिक परंपराओं से संबंधित
                            मान्यताएँ क्षेत्र एवं परंपरा के अनुसार
                            अलग-अलग हो सकती हैं।
                        """.trimIndent(),
                        fontSize = 13.sp,
                        lineHeight = 20.sp,
                        color = Color(0xFF5D4037)
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            // ---------------------------------------------------------
            // FOOTER
            // ---------------------------------------------------------

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "ॐ नमः शिवाय",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF8D4A00)
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = "हर हर महादेव 🔱",
                    fontSize = 15.sp,
                    color = Color(0xFF6D4C41)
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text = "Version 1.0.0",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}


// =====================================================================
// ABOUT CARD
// =====================================================================

@Composable
fun AboutCard(
    icon: ImageVector,
    title: String,
    text: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 7.dp
            ),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF8E1)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {

            // Icon Background

            Box(
                modifier = Modifier
                    .size(44.dp)
                    .background(
                        color = Color(0xFFFFE0B2),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color(0xFFE67E00),
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(
                modifier = Modifier.width(14.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF9C2F12)
                )

                Spacer(
                    modifier = Modifier.height(7.dp)
                )

                Text(
                    text = text,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    color = Color(0xFF5D4037)
                )
            }
        }
    }
}

@Composable
@Preview
fun PreviewAboutUsScreen() {
    AboutUsScreen(onBackPress = {})
}