package com.sopt.sopkathon_android1.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// Greyscale Colors
val Gray_100 = Color(0xFFFEFEFE)
val Gray_200 = Color(0xFFFAFAFA)
val Gray_300 = Color(0xFFF4F6F8)
val Gray_400 = Color(0xFFE6E6E6)
val Gray_500 = Color(0xFFC3C3C3)
val Gray_600 = Color(0xFF919191)
val Gray_700 = Color(0xFF616161)
val Gray_800 = Color(0xFF212121)

// Brand Colors
val Blue_500 = Color(0xFF5061FF)
val Blue_300 = Color(0xFF98B6FF)
val Blue_100 = Color(0xFFBFD6F4)

val SubYellow = Color(0xFFFFDA50)
val SubPink = Color(0xFFFFCFED)
@Immutable
data class SopkathonColors(
    val gray_100: Color = Gray_100,
    val gray_200: Color = Gray_200,
    val gray_300: Color = Gray_300,
    val gray_400: Color = Gray_400,
    val gray_500: Color = Gray_500,
    val gray_600: Color = Gray_600,
    val gray_700: Color = Gray_700,
    val gray_800: Color = Gray_800,

    val blue_500: Color = Blue_500,
    val blue_300: Color = Blue_300,
    val blue_100: Color = Blue_100,

    val subYellow: Color = SubYellow,
    val subPink: Color = SubPink,
)

val defaultSopkathonColors = SopkathonColors(
    gray_100 = Gray_100,
    gray_200 = Gray_200,
    gray_300 = Gray_300,
    gray_400 = Gray_400,
    gray_500 = Gray_500,
    gray_600 = Gray_600,
    gray_700 = Gray_700,
    gray_800 = Gray_800,

    blue_500 = Blue_500,
    blue_300 = Blue_300,
    blue_100 = Blue_100,

    subYellow = SubYellow,
    subPink = SubPink,
)

val localSopkathonColorsProvider = staticCompositionLocalOf { defaultSopkathonColors }
