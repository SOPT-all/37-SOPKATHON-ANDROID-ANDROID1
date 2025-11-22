package com.sopt.sopkathon_android1.core.designsystem.theme

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat

object SopkathonTheme {
    val colors: SopkathonColors
        @Composable
        @ReadOnlyComposable
        get() = localSopkathonColors.current

    val typography: SopkathonTypography
        @Composable
        @ReadOnlyComposable
        get() = localSopkathonTypography.current
}

@Composable
fun ProvideSopkathonColorsAndTypography(
    colors: SopkathonColors,
    typography: SopkathonTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        localSopkathonColors provides colors,
        localSopkathonTypography provides typography,
        content = content
    )
}

@Composable
fun SOPKATHONTheme(
    content: @Composable () -> Unit
) {
    ProvideSopkathonColorsAndTypography(
        colors = defaultSopkathonColors,
        typography = defaultSopkathonTypography
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    WindowCompat.getInsetsController(
                        this,
                        view
                    )//.isAppearanceLightStatusBars = ture
                }
            }
        }
    }
    MaterialTheme(
        content = content
    )
}

@Preview(showBackground = true, heightDp = 1000)
@Composable
private fun SopkathonMainColorsPreview() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .background(SopkathonTheme.colors.gray_100) // 배경색 확인
            .padding(16.dp)
    ) {
        // Brand Colors Check
        Text(
            text = "SopkathonTheme - Blue 500",
            style = SopkathonTheme.typography.headlineBold24,
            color = SopkathonTheme.colors.blue_500,
        )
        Text(
            text = "SopkathonTheme - Blue 300",
            style = SopkathonTheme.typography.headlineSemiBold20,
            color = SopkathonTheme.colors.blue_300,
        )
        Text(
            text = "SopkathonTheme - Blue 100",
            style = SopkathonTheme.typography.titleBold18,
            color = SopkathonTheme.colors.blue_100,
        )

        // Sub Colors Check
        Text(
            text = "SopkathonTheme - Sub Yellow",
            style = SopkathonTheme.typography.titleSemiBold16,
            color = SopkathonTheme.colors.subYellow,
        )
        Text(
            text = "SopkathonTheme - Sub Pink",
            style = SopkathonTheme.typography.bodyMedium16,
            color = SopkathonTheme.colors.subPink,
        )

        // Grayscale Check
        Text(
            text = "SopkathonTheme - Gray 800",
            style = SopkathonTheme.typography.bodyRegular14,
            color = SopkathonTheme.colors.gray_800,
        )
        Text(
            text = "SopkathonTheme - Gray 700",
            style = SopkathonTheme.typography.descriptionMedium12,
            color = SopkathonTheme.colors.gray_700,
        )
        Text(
            text = "SopkathonTheme - Gray 600",
            style = SopkathonTheme.typography.descriptionMedium10,
            color = SopkathonTheme.colors.gray_600,
        )
        Text(
            text = "SopkathonTheme - Gray 500",
            style = SopkathonTheme.typography.bodyMedium16,
            color = SopkathonTheme.colors.gray_500,
        )
        Text(
            text = "SopkathonTheme - Gray 400",
            style = SopkathonTheme.typography.bodyRegular14,
            color = SopkathonTheme.colors.gray_400,
        )
        Text(
            text = "SopkathonTheme - Gray 300",
            style = SopkathonTheme.typography.descriptionMedium12,
            color = SopkathonTheme.colors.gray_300,
        )
        Text(
            text = "SopkathonTheme - Gray 200",
            style = SopkathonTheme.typography.descriptionMedium10,
            color = SopkathonTheme.colors.gray_200,
        )
    }
}