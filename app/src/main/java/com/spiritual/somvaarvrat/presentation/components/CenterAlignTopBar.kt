package com.spiritual.somvaarvrat.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterAlignTopBar(
    title: String,
    onBack: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    backgroundColor: Color? = null,
    gradientBrush: Brush? = null,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    // Determine container color: if gradient is provided, use transparent so brush is visible.
    val containerColor = when {
        gradientBrush != null -> Color.Transparent
        backgroundColor != null -> backgroundColor
        else -> MaterialTheme.colorScheme.surface
    }

    // Choose content colors: use white text/icons when gradient is present for contrast,
    // otherwise use theme's on-surface color.
    val titleContentColor =
        if (gradientBrush != null) Color.White else MaterialTheme.colorScheme.onSurface
    val navIconContentColor =
        if (gradientBrush != null) Color.White else MaterialTheme.colorScheme.onSurface
    val actionIconContentColor =
        if (gradientBrush != null) Color.White else MaterialTheme.colorScheme.onSurface

    // Apply gradient brush if provided via modifier
    val appliedModifier = if (gradientBrush != null) {
        modifier.background(gradientBrush)
    } else {
        modifier
    }

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = titleContentColor
            )
        },
        navigationIcon = {
            if (onBack != null) {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = navIconContentColor
                    )
                }
            }
        },
        actions = {
            // actions will inherit actionIconContentColor via colors below (but individual
            // icons can set tint explicitly if needed)
            actions()
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = containerColor,
            titleContentColor = titleContentColor,
            navigationIconContentColor = navIconContentColor,
            actionIconContentColor = actionIconContentColor
        ),
        modifier = appliedModifier
    )
}

// Preview showing the requested gradient (light sky -> blue -> deep Shiva blue)
@Preview(showBackground = true)
@Composable
fun CenterAlignTopBarPreview() {
    val shivaGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFE3F2FD),
            Color(0xFF64B5F6),
            Color(0xFF0D47A1)
        )
    )

    CenterAlignTopBar(
        title = "Sample Title",
        onBack = { /* no-op */ },
        gradientBrush = shivaGradient
    )
}