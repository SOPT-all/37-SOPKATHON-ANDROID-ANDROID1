package com.sopt.sopkathon_android1.presentation.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.sopkathon_android1.core.designsystem.theme.SOPKATHONTheme
import com.sopt.sopkathon_android1.core.designsystem.theme.SopkathonTheme
import com.sopt.sopkathon_android1.data.dto.info.BalanceGameInfo

private const val CARD_RATIO = 143 / 236f

@Composable
fun HotBalanceGameRow(
    balanceGames: List<BalanceGameInfo>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 26.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        items(
            items = balanceGames,
            key = { item -> item.balanceGameId },
            contentType = { item -> item.category }
        ) { item ->
            HotBalanceGameCard(
                title = item.title,
                option1 = item.option1Title,
                option2 = item.option2Title,
            )
        }
    }
}

@Composable
private fun HotBalanceGameCard(
    title: String,
    option1: String,
    option2: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .border(
                width = 1.dp,
                color = SopkathonTheme.colors.blue_300,
                shape = RoundedCornerShape(20.dp),
            )
            .width(143.dp)
            .aspectRatio(CARD_RATIO),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(horizontal = 16.dp),
            color = SopkathonTheme.colors.gray_700,
            style = SopkathonTheme.typography.bodyMedium16,
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            Text(
                text = option1,
                color = SopkathonTheme.colors.gray_800,
                style = SopkathonTheme.typography.descriptionMedium12,
            )

            Text(
                text = "VS",
                color = SopkathonTheme.colors.gray_800,
                style = SopkathonTheme.typography.descriptionMedium12,
            )

            Text(
                text = option2,
                color = SopkathonTheme.colors.gray_800,
                style = SopkathonTheme.typography.descriptionMedium12,
            )
        }
    }
}

@Preview
@Composable
private fun HotBalanceGameRowPreview() {
    SOPKATHONTheme {
        HotBalanceGameRow(
            balanceGames = listOf(
                BalanceGameInfo(
                    balanceGameId = 1,
                    title = "시험 전날",
                    option1Title = "라면",
                    option2Title = "탄산",
                    isLike = false,
                    memberOption = "OPTION1", // 사용자가 선택한 옵션 (예: 서버값)
                    option1Total = 150,
                    option2Total = 45,
                    deadline = "D-5",
                    category = "FOOD"
                ),
                BalanceGameInfo(
                    balanceGameId = 2,
                    title = "시험 전날",
                    option1Title = "재입대",
                    option2Title = "그냥 살기",
                    isLike = true, // 좋아요 누름
                    memberOption = "", // 아직 투표 안 함
                    option1Total = 12,
                    option2Total = 300,
                    deadline = "D-1",
                    category = "FANTASY"
                ),
                BalanceGameInfo(
                    balanceGameId = 3,
                    title = "시험 전날",
                    option1Title = "연락 두절",
                    option2Title = "여사친/남사친 부자",
                    isLike = false,
                    memberOption = "OPTION2",
                    option1Total = 89,
                    option2Total = 92,
                    deadline = "D-Day",
                    category = "LOVE"
                )
            )
        )
    }
}
