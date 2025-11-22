package com.sopt.sopkathon_android1.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.sopkathon_android1.R.drawable.icon_arrow_right
import com.sopt.sopkathon_android1.core.designsystem.theme.SOPKATHONTheme
import com.sopt.sopkathon_android1.core.designsystem.theme.SopkathonTheme
import com.sopt.sopkathon_android1.core.util.noRippleClickable

@Composable
fun TitleRow(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = title,
            color = SopkathonTheme.colors.gray_800,
            style = SopkathonTheme.typography.titleSemiBold16,
        )

        Icon(
            imageVector = ImageVector.vectorResource(icon_arrow_right),
            contentDescription = null,
            modifier = Modifier.noRippleClickable(onClick = onClick)
        )
    }
}

@Preview
@Composable
private fun TitleRowPreview() {
    SOPKATHONTheme {
        TitleRow(
            title = "가장 최악의 이별을 고르자면?",
            onClick = {},
        )
    }
}
