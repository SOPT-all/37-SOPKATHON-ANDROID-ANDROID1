package com.sopt.sopkathon_android1.core.designsystem.component

import androidx.annotation.DrawableRes
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.sopkathon_android1.core.designsystem.theme.SopkathonTheme
import com.sopt.sopkathon_android1.R

@Composable
fun SopkathonTopappbar (
    title: String,
    modifier: Modifier = Modifier,
){
    Row (
        modifier = modifier
            .fillMaxWidth()
            .background(SopkathonTheme.colors.gray_100)
            .padding(horizontal = 16.dp, vertical = 16.dp),
    ){
        Icon(
            painter = painterResource(id = R.drawable.icon_arrow_left),
            contentDescription = null,
            tint = SopkathonTheme.colors.gray_800,
        )

        Spacer(modifier = Modifier.width(24.dp))

        Text(
            text = title,
            modifier = Modifier.align(Alignment.CenterVertically),
            color = SopkathonTheme.colors.gray_800,
            style = SopkathonTheme.typography.bodyMedium16,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SopkathonHeaderPreview() {
    SopkathonTopappbar(
        "오늘의 밸런스"
    )
}