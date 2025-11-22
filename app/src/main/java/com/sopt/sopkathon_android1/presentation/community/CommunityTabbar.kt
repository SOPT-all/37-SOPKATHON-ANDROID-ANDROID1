package com.sopt.sopkathon_android1.presentation.community

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.sopkathon_android1.core.designsystem.theme.SopkathonTheme
import com.sopt.sopkathon_android1.core.util.noRippleClickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun CommunityTabbar(
    selectedTab: String?,
    onTabSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        CommunityTabbarItem(
            tabTitle = "연애",
            onClick = { onTabSelected("연애") },
            selected = selectedTab == "연애",
            boxColor = SopkathonTheme.colors.subPink,
        )

        CommunityTabbarItem(
            tabTitle = "유머",
            onClick = { onTabSelected("유머") },
            selected = selectedTab == "유머",
            boxColor = SopkathonTheme.colors.subYellow,
        )

        CommunityTabbarItem(
            tabTitle = "학업",
            onClick = { onTabSelected("학업") },
            selected = selectedTab == "학업",
            boxColor = SopkathonTheme.colors.blue_300,
        )

        CommunityTabbarItem(
            tabTitle = "기타",
            onClick = { onTabSelected("기타") },
            selected = selectedTab == "기타",
            boxColor = SopkathonTheme.colors.gray_600,
        )
    }
}

@Composable
private fun CommunityTabbarItem(
    tabTitle: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    boxColor: Color = SopkathonTheme.colors.gray_100,
) {
    Row(
        modifier = modifier
            .noRippleClickable(onClick = onClick)
            .border(
                width = 0.5.dp,
                color = if (selected) SopkathonTheme.colors.blue_500 else SopkathonTheme.colors.gray_500,
                shape = RoundedCornerShape(99.dp)
            )
            .padding(horizontal = 14.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(CircleShape)
                .background(color = boxColor),
        )

        Text(
            text = tabTitle,
            modifier = Modifier,
            color = if (selected) SopkathonTheme.colors.blue_500 else SopkathonTheme.colors.gray_500,
            style = SopkathonTheme.typography.bodyMedium16,
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun SopkathonCommunityTabbarPreview() {
    var selectedTab by remember { mutableStateOf<String?>(null) }

    CommunityTabbar(
        selectedTab = selectedTab,
        onTabSelected = { tab ->
            selectedTab = tab
        }
    )
}
