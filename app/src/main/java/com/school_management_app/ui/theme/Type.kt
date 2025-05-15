package com.school_management_app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.school_management_app.utilities.customFontFamily

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
//        fontFamily = FontFamily.Default,
        fontFamily = customFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
//        color = Color.Red,
//        color = Color.White,
        textAlign = TextAlign.Center
    ),
    bodyMedium = TextStyle(
//        fontFamily = FontFamily.Default,
        fontFamily = customFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
//        color = Color.Red,
//        color = Color.White,
//        textAlign = TextAlign.Center
    ),
    bodySmall = TextStyle(
//        fontFamily = FontFamily.Default,
        fontFamily = customFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp,
//        color = Color.Red,
//        color = Color.White,
//        textAlign = TextAlign.Center
    ),
    // Other default text styles to override
    headlineLarge = TextStyle(
        fontFamily = customFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
//        color = Color.White,
        textAlign = TextAlign.Center,
    ),
    headlineSmall = TextStyle(
        fontFamily = customFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 25.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
//        color = Color.White,
        textAlign = TextAlign.Center,
    ),
    titleLarge = TextStyle(
        fontFamily = customFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 25.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
//        color = Color.White,
        textAlign = TextAlign.Center,
    ),
    //This is for button text
    labelLarge = TextStyle(
        fontFamily = customFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
//        lineHeight = 28.sp,
//        letterSpacing = 0.sp,
//        color = Color.White,
        textAlign = TextAlign.Center
    ),
    //This is for inputfield text
    labelMedium = TextStyle(
        fontFamily = customFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
//        lineHeight = 28.sp,
//        letterSpacing = 0.sp,
//        color = Color.White,
        textAlign = TextAlign.Center
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )

)