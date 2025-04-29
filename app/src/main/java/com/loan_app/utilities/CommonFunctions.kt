package com.loan_app.utilities

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.res.fontResource
import com.loan_app.R

fun customFontFamily(): FontFamily{
    return FontFamily(
        Font(R.font.josefin_slab_light, weight = FontWeight.Light),
        Font(R.font.josefin_slab_regular, weight = FontWeight.Normal),
        Font(R.font.josefin_slab_bold, weight = FontWeight.Bold),
        Font(R.font.josefin_slab_thin, weight = FontWeight.Thin)
    )
}