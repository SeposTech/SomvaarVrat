package com.spiritual.somvaarvrat.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.spiritual.somvaarvrat.utils.TrackScreen

@Composable
fun PujaVidhiScreen(
    navController: NavController
) {
    TrackScreen("PoojaVidhiScreen")
    val backgroundColor = Color(0xFFFFFAF5)
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
                title = "About Us",
                gradientBrush = topBarGradient,
                onBack = { navController.popBackStack() }
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .navigationBarsPadding(),

        containerColor = backgroundColor

    ) { innerPadding ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())

        ) {


            Spacer(modifier = Modifier.height(18.dp))

            // HEADER SECTION

            Column(
                modifier = Modifier.fillMaxWidth(),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .size(110.dp)
                        .clip(CircleShape)
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFFFFF1DC),
                                    Color.White
                                )
                            )
                        ),

                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "🕉️",
                        fontSize = 52.sp
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "सरल और संपूर्ण पूजा विधि",

                    color = Color(0xFF9C2F12),

                    fontSize = 28.sp,

                    textAlign = TextAlign.Center,

                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "भगवान शिव की पूजा करने की\nविधि और सामग्री",

                    color = Color(0xFF6D4C41),

                    fontSize = 18.sp,

                    lineHeight = 30.sp,

                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(28.dp))

            // IMPORTANCE CARD

            Card(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),

                shape = RoundedCornerShape(30.dp),

                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),

                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                )
            ) {

                Column(
                    modifier = Modifier.padding(22.dp)
                ) {

                    Text(
                        text = "सोमवार व्रत का महत्व",

                        color = Color(0xFFB23A16),

                        fontSize = 24.sp,

                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    Text(
                        text =
                            "सोमवार का व्रत साधारणतया दिन के तीसरे पहर (दोपहर के बाद) तक किया जाता है।",

                        color = Color(0xFF4E342E),

                        fontSize = 17.sp,

                        lineHeight = 30.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text =
                            "इस व्रत में फलाहार या पारायण (विशेष भोजन नियम) का कोई कठोर नियम नहीं होता, किन्तु यह आवश्यक माना गया है कि दिन और रात में केवल एक ही बार भोजन ग्रहण किया जाए।",

                        color = Color(0xFF4E342E),

                        fontSize = 17.sp,

                        lineHeight = 30.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text =
                            "सोमवार व्रत में भगवान शिव तथा माता पार्वती जी की विधि-विधान से पूजा की जाती है। भक्त पूरे दिन संयम, शुद्धता और श्रद्धा के साथ व्रत का पालन करते हैं।",

                        color = Color(0xFF4E342E),

                        fontSize = 17.sp,

                        lineHeight = 30.sp
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "📿 व्रत के प्रकार",

                        color = Color(0xFFB23A16),

                        fontSize = 22.sp,

                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text =
                            "• साधारण प्रति सोमवार व्रत\n\n" +
                                    "• सौम्य प्रदोष व्रत\n\n" +
                                    "• सोलह सोमवार व्रत",

                        color = Color(0xFF4E342E),

                        fontSize = 17.sp,

                        lineHeight = 30.sp
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text =
                            "इन तीनों व्रतों की पूजा विधि लगभग समान होती है, लेकिन इनके नियम और फल भिन्न-भिन्न माने गए हैं।",

                        color = Color(0xFF4E342E),

                        fontSize = 17.sp,

                        lineHeight = 30.sp
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "🪔 पूजा विधि",

                        color = Color(0xFFB23A16),

                        fontSize = 22.sp,

                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text =
                            "पूजा में भगवान शिव का जल, दूध, बेलपत्र, धतूरा, भस्म आदि से अभिषेक किया जाता है।",

                        color = Color(0xFF4E342E),

                        fontSize = 17.sp,

                        lineHeight = 30.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text =
                            "साथ ही माता पार्वती की भी पूजा की जाती है।",

                        color = Color(0xFF4E342E),

                        fontSize = 17.sp,

                        lineHeight = 30.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text =
                            "पूजा के बाद भगवान शिव की आरती की जाती है और श्रद्धापूर्वक व्रत कथा सुनी जाती है।",

                        color = Color(0xFF4E342E),

                        fontSize = 17.sp,

                        lineHeight = 30.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // PUJA SAMAGRI CARD

            Card(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),

                shape = RoundedCornerShape(
                    topStart = 34.dp,
                    topEnd = 34.dp
                ),

                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),

                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                )
            ) {

                Column(
                    modifier = Modifier.padding(22.dp)
                ) {

                    Text(
                        text = "पूजा की सामग्री",

                        color = Color(0xFFB23A16),

                        fontSize = 24.sp,

                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    val leftItems = listOf(
                        "🥣  जल (गंगाजल हो तो उत्तम)",
                        "🥛  कच्चा दूध",
                        "🍯  शहद",
                        "🫓  शक्कर",
                        "🌺  धतूरा",
                        "🥣  चन्दन",
                        "🪔  फल और मिठान"
                    )

                    val rightItems = listOf(
                        "🥣  दही",
                        "🪔  घी",
                        "🍃  बिल्व पत्र",
                        "🌼  सफेद फूल",
                        "🪔  धूप, दीप"
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),

                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column(
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {

                            leftItems.forEach {

                                Text(
                                    text = it,

                                    color = Color(0xFF3E2723),

                                    fontSize = 17.sp
                                )
                            }
                        }

                        Column(
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {

                            rightItems.forEach {

                                Text(
                                    text = it,

                                    color = Color(0xFF3E2723),

                                    fontSize = 17.sp
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(26.dp))

                    HorizontalDivider(
                        color = Color(0xFFFFE0CC)
                    )

                    Spacer(modifier = Modifier.height(26.dp))

                    Text(
                        text = "पूजा विधि (स्टेप बाय स्टेप)",

                        color = Color(0xFFB23A16),

                        fontSize = 24.sp,

                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(22.dp))

                    // STEP 1

                    Card(

                        modifier = Modifier.fillMaxWidth(),

                        shape = RoundedCornerShape(22.dp),

                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFFFFBF7)
                        )
                    ) {

                        Column(
                            modifier = Modifier.padding(18.dp)
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Box(
                                    modifier = Modifier
                                        .size(34.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFFFFC94D)),

                                    contentAlignment = Alignment.Center
                                ) {

                                    Text(
                                        text = "1",

                                        fontWeight = FontWeight.Bold,

                                        color = Color.Black
                                    )
                                }

                                Text(
                                    text = "   स्नान करें और स्वच्छ वस्त्र धारण करें।",

                                    color = Color(0xFF3E2723),

                                    fontSize = 17.sp,

                                    fontWeight = FontWeight.Medium
                                )
                            }

                            Spacer(modifier = Modifier.height(20.dp))

                            Box(
                                modifier = Modifier
                                    .size(90.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(Color(0xFFFFF1DC)),

                                contentAlignment = Alignment.Center
                            ) {

                                Text(
                                    text = "🛕",
                                    fontSize = 50.sp
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    // STEP 2

                    Card(

                        modifier = Modifier.fillMaxWidth(),

                        shape = RoundedCornerShape(22.dp),

                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFFFFBF7)
                        )
                    ) {

                        Column(
                            modifier = Modifier.padding(18.dp)
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Box(
                                    modifier = Modifier
                                        .size(34.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFFFFC94D)),

                                    contentAlignment = Alignment.Center
                                ) {

                                    Text(
                                        text = "2",

                                        fontWeight = FontWeight.Bold,

                                        color = Color.Black
                                    )
                                }

                                Text(
                                    text = "   शिवलिंग पर जल और दूध अर्पित करें।",

                                    color = Color(0xFF3E2723),

                                    fontSize = 17.sp,

                                    fontWeight = FontWeight.Medium
                                )
                            }

                            Spacer(modifier = Modifier.height(20.dp))

                            Box(
                                modifier = Modifier
                                    .size(90.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(Color(0xFFFFF1DC)),

                                contentAlignment = Alignment.Center
                            ) {

                                Text(
                                    text = "🪔",
                                    fontSize = 50.sp
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPujaVidhiScreen() {
    PujaVidhiScreen(rememberNavController())
}