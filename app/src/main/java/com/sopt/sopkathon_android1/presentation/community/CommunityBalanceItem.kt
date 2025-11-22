package com.sopt.sopkathon_android1.presentation.community

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.sopkathon_android1.R
import com.sopt.sopkathon_android1.core.designsystem.theme.SopkathonTheme

@Composable
fun CommunityBalanceItem(
    title: String,
    box1: String,
    box2: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        CommunityBalanceTitle(
            title = title
        )

        CommunityBalanceChoose(
            box1 = box1,
            box2 = box2
        )
    }

}

@Composable
private fun CommunityBalanceTitle(
    title: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            color = SopkathonTheme.colors.gray_800,
            style = SopkathonTheme.typography.bodyMedium16,
        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.icon_arrow_right),
            contentDescription = null,
            tint = SopkathonTheme.colors.blue_500,
        )
    }

}

@Composable
private fun CommunityBalanceChoose(
    box1: String,
    box2: String,
    modifier: Modifier = Modifier,
) {
    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    val hasAnySelected = selectedIndex != null

    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        CommunityBalanceItemBox(
            title = box1,
            selected = selectedIndex == 1,
            hasAnySelected = hasAnySelected,
            modifier = Modifier
                .weight(1f)
                .clickable {
                    selectedIndex = if (selectedIndex == 1) null else 1
                }
        )

        CommunityBalanceItemBox(
            title = box2,
            selected = selectedIndex == 1,
            hasAnySelected = hasAnySelected,
            modifier = Modifier
                .weight(1f)
                .clickable {
                    selectedIndex = if (selectedIndex == 1) null else 1
                }
        )
    }
}

@Composable
private fun CommunityBalanceItemBox(
    title: String,
    selected: Boolean = false,
    hasAnySelected: Boolean = false,
    modifier: Modifier = Modifier,
) {
    val itemAlpha = when {
        selected -> 1f
        hasAnySelected -> 0.6f
        else -> 1f
    }

    Box(
        modifier = modifier
            .alpha(itemAlpha)
            .border(
                width = 1.5.dp,
                color = if (selected) SopkathonTheme.colors.blue_500 else SopkathonTheme.colors.gray_600,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth(),
            color = if (selected) SopkathonTheme.colors.blue_500 else SopkathonTheme.colors.gray_600,
            style = SopkathonTheme.typography.descriptionMedium10,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SopkathonCommunityTabbarPreview() {

    CommunityBalanceItem(
        title = "서운한 일이 있었을 때, 어떤 스타일이 더 나아?",
        box1 = "감정 바로 말하는 스타일",
        box2 = "감정 말 안하고 쌓아두는 스타일"
    )
}