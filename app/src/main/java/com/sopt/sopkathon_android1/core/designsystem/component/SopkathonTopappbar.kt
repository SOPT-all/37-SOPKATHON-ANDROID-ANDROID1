package com.sopt.sopkathon_android1.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.sopkathon_android1.R
import com.sopt.sopkathon_android1.core.designsystem.theme.SopkathonTheme

@Composable
fun SopkathonTopappbar(
    title: String,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .background(SopkathonTheme.colors.gray_100)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(24.dp),
    ){
        navigationIcon()

        Text(
            text = title,
            color = SopkathonTheme.colors.gray_800,
            style = SopkathonTheme.typography.bodyMedium16,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SopkathonHeaderPreview() {
    SopkathonTopappbar(
        title = "오늘의 밸런스",
        navigationIcon = {
            Icon(
                modifier = Modifier,
                imageVector = ImageVector.vectorResource(R.drawable.icon_arrow_left),
                contentDescription = null,
                tint = SopkathonTheme.colors.gray_800,
            )
        },
    )
}
