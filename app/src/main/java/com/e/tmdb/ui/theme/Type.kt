package com.e.tmdb.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.e.tmdb.R

val Alata = FontFamily(
    Font(R.font.alata_regular)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    h1 =  TextStyle(
        fontFamily = Alata,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        color = DarkBlue
    ),
    h2 =  TextStyle(
        fontFamily = Alata,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = DarkBlue
    )


    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
