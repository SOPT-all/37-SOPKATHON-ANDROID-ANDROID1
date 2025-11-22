package com.sopt.sopkathon_android1.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(SopkathonTheme.colors.gray_100)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.icon_arrow_left),
            contentDescription = null,
            tint = SopkathonTheme.colors.gray_800,
        )

        Spacer(modifier = Modifier.width(24.dp))

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
        title = "오늘의 밸런스"
    )
}
