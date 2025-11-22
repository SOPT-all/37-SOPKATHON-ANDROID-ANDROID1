package com.sopt.sopkathon_android1.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.sopt.sopkathon_android1.R

// Set of Material typography styles to start with

object RobotoFont {
    val Bold = FontFamily(
        Font(R.font.roboto_bold)
    )

    val SemiBold = FontFamily(
        Font(R.font.roboto_semibold)
    )

    val Medium = FontFamily(
        Font(R.font.roboto_medium)
    )

    val Regular = FontFamily(
        Font(R.font.roboto_regular)
    )
}


@Immutable
data class SopkathonTypography(
    // Headline
    val headlineBold24: TextStyle,
    val headlineSemiBold20: TextStyle,

    // Title
    val titleBold18: TextStyle,
    val titleSemiBold16: TextStyle,

    // Body
    val bodyMedium16: TextStyle,
    val bodyRegular14: TextStyle,

    // Description
    val descriptionMedium12: TextStyle,
    val descriptionMedium10: TextStyle
)


private fun sopkathonTextStyle(
    fontFamily: FontFamily,
    fontSize: TextUnit,
    lineHeight: TextUnit = TextUnit.Unspecified,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null
): TextStyle =
    TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize,
        lineHeight = lineHeight,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        ),
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    )

val defaultSopkathonTypography = SopkathonTypography(
    headlineBold24 = sopkathonTextStyle(
        fontFamily = RobotoFont.Bold,
        fontSize = 24.sp,
        lineHeight = 31.2.sp
    ),
    headlineSemiBold20 = sopkathonTextStyle(
        fontFamily = RobotoFont.SemiBold,
        fontSize = 20.sp,
        lineHeight = 26.sp
    ),
    titleBold18 = sopkathonTextStyle(
        fontFamily = RobotoFont.Bold,
        fontSize = 18.sp,
        lineHeight = 23.4.sp
    ),
    titleSemiBold16 = sopkathonTextStyle(
        fontFamily = RobotoFont.SemiBold,
        fontSize = 16.sp,
        lineHeight = 20.8.sp
    ),
    bodyMedium16 = sopkathonTextStyle(
        fontFamily = RobotoFont.Medium,
        fontSize = 16.sp,
        lineHeight = 20.8.sp
    ),
    bodyRegular14 = sopkathonTextStyle(
        fontFamily = RobotoFont.Regular,
        fontSize = 14.sp,
        lineHeight = 18.2.sp
    ),
    descriptionMedium12 = sopkathonTextStyle(
        fontFamily = RobotoFont.Medium,
        fontSize = 12.sp,
        lineHeight = 15.6.sp
    ),
    descriptionMedium10 = sopkathonTextStyle(
        fontFamily = RobotoFont.Medium,
        fontSize = 12.sp,
        lineHeight = 15.6.sp
    )
)
    val localSopkathonTypography = staticCompositionLocalOf { defaultSopkathonTypography }
