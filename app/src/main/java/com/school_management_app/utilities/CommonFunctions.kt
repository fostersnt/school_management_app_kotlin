package com.school_management_app.utilities

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.school_management_app.R
import com.school_management_app.data.model.AppColors

fun customFontFamily(): FontFamily{
    return FontFamily(
        Font(R.font.josefin_slab_light, weight = FontWeight.Light),
        Font(R.font.josefin_slab_regular, weight = FontWeight.Normal),
        Font(R.font.josefin_slab_bold, weight = FontWeight.Bold),
        Font(R.font.josefin_slab_thin, weight = FontWeight.Thin)
    )
}

//val CustomColorScheme = lightColorScheme(
//    primary = Color(0xFF00729C),
//    onPrimary = Color.White,
//    // Define other colors as needed
//)

val CustomColorScheme = lightColorScheme(
    primary = Color(AppColors.BACKGROUND_COLOR),
//    primary = Color(0xFF005A7A),
    secondary = Color(0xFFff3779),
    background = Color.White,
    surface = Color(AppColors.WHITE_COLOR),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black
)