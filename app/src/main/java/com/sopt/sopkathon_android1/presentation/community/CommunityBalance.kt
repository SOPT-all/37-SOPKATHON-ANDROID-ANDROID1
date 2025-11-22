package com.sopt.sopkathon_android1.presentation.community

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.sopkathon_android1.core.designsystem.theme.SopkathonTheme
import java.util.UUID

@Composable
fun CommunityBalance(
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .background(SopkathonTheme.colors.gray_100),
    ) {

        itemsIndexed(balances, key = { _, item -> item.balanceId }) { index, item ->

            CommunityBalanceItem(
                title = item.title,
                box1 = item.option1Title,
                box2 = item.option2Title,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            )

            if (index != balances.lastIndex) {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = SopkathonTheme.colors.gray_500,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
            }
        }
    }
}


data class CommunityBalanceModel(
    val title: String,
    val option1Title: String,
    val option2Title: String,
    val balanceId: String = UUID.randomUUID().toString(),
)

private val balances = listOf(
    CommunityBalanceModel(
        title = "홍학의 자리",
        option1Title = "짜장면",
        option2Title = "짬뽕"
    ),
    CommunityBalanceModel(
        title = "홍학의 자리",
        option1Title = "짜장면",
        option2Title = "짬뽕"
    ),
    CommunityBalanceModel(
        title = "홍학의 자리",
        option1Title = "짜장면",
        option2Title = "짬뽕"
    ),
    CommunityBalanceModel(
        title = "홍학의 자리",
        option1Title = "짜장면",
        option2Title = "짬뽕"
    ),
    CommunityBalanceModel(
        title = "홍학의 자리",
        option1Title = "짜장면",
        option2Title = "짬뽕"
    ),
)


@Preview(showBackground = true)
@Composable
private fun SopkathonCommunityTabbarPreview() {
    CommunityBalance()
}