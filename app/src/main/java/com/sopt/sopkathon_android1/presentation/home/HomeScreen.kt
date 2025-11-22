package com.sopt.sopkathon_android1.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sopt.sopkathon_android1.R.drawable.image_character_smile
import com.sopt.sopkathon_android1.R.drawable.image_logo
import com.sopt.sopkathon_android1.core.designsystem.component.BalanceGameCard
import com.sopt.sopkathon_android1.core.designsystem.theme.SOPKATHONTheme
import com.sopt.sopkathon_android1.core.designsystem.theme.SopkathonTheme
import com.sopt.sopkathon_android1.presentation.home.components.HotBalanceGameRow
import com.sopt.sopkathon_android1.presentation.home.components.TitleRow
import kotlinx.coroutines.delay
import java.time.Duration
import java.time.LocalDateTime

private const val LOGO_RATIO = 150 / 37f
private const val CHARACTER_RATIO = 164 / 164f

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val paddedModifier = Modifier.padding(horizontal = 20.dp)
    val scrollState = rememberScrollState()
    val uiState by viewModel.homeUiState.collectAsStateWithLifecycle()
    var remainingText by remember { mutableStateOf("") }

    LaunchedEffect(uiState.todayBalanceGame?.deadline) {
        if (!uiState.todayBalanceGame?.deadline.isNullOrEmpty()) {
            while (true) {
                remainingText = try {
                    calculateRemainingTime(uiState.todayBalanceGame?.deadline)
                } catch (e: Exception) {
                    "시간 정보 오류"
                }
                delay(1000L)
            }
        }
    }

    Box(
        modifier = modifier
            .background(SopkathonTheme.colors.blue_500)
            .statusBarsPadding()
            .fillMaxWidth()
            .verticalScroll(scrollState),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 10.dp,
                    start = 20.dp,
                    end = 17.dp,
                ),
            horizontalArrangement = Arrangement.spacedBy(9.dp),
        ) {
            Image(
                painter = painterResource(image_logo),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(LOGO_RATIO),
            )

            Image(
                painter = painterResource(image_character_smile),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(CHARACTER_RATIO),
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 111.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                    )
                )
                .background(SopkathonTheme.colors.gray_100),
        ) {
            Spacer(Modifier.height(40.dp))

            Column {
                Text(
                    text = "아테네 시민이여,\n오늘의 선택은?",
                    modifier = paddedModifier,
                    color = SopkathonTheme.colors.blue_500,
                    style = SopkathonTheme.typography.headlineSemiBold20,
                )

                Spacer(Modifier.height(12.dp))

                TitleRow(
                    title = uiState.todayBalanceGame?.title.orEmpty(),
                    onClick = {},
                    modifier = paddedModifier,
                )

                Spacer(Modifier.height(12.dp))

                BalanceGameCard(
                    option1Title = uiState.todayBalanceGame?.option1Title.orEmpty(),
                    option1Total = uiState.todayBalanceGame?.option1Total ?: 0,
                    option2Title = uiState.todayBalanceGame?.option2Title.orEmpty(),
                    option2Total = uiState.todayBalanceGame?.option2Total ?: 0,
                    onClick = {
                        // TODO: API 호출
                    },
                    modifier = Modifier.padding(horizontal = 24.dp),
                )

                Spacer(Modifier.height(16.dp))

                Text(
                    text = remainingText,
                    modifier = paddedModifier,
                    color = SopkathonTheme.colors.blue_500,
                    style = SopkathonTheme.typography.descriptionMedium12,
                )

                Spacer(Modifier.height(36.dp))

                TitleRow(
                    title = "내가 참여중인 밸런스게임",
                    onClick = {},
                    modifier = paddedModifier,
                )

                Spacer(Modifier.height(12.dp))

                // TODO: 투표 리스트

                Spacer(Modifier.height(16.dp))

                Text(
                    text = "🔥 오늘의 hot 밸런스",
                    modifier = paddedModifier,
                    color = SopkathonTheme.colors.gray_800,
                    style = SopkathonTheme.typography.titleSemiBold16,
                )
            }

            Spacer(Modifier.height(13.dp))

            HotBalanceGameRow(balanceGames = uiState.hotBalanceGames)
        }
    }
}

private fun calculateRemainingTime(deadlineString: String?): String {
    val deadline = LocalDateTime.parse(deadlineString)
    val now = LocalDateTime.now()
    val duration = Duration.between(now, deadline)
    val hours = duration.toHours() % 24
    val minutes = duration.toMinutes() % 60
    val seconds = duration.seconds % 60

    return "투표 종료까지 ${hours}시간 ${minutes}분 ${seconds}초 남았습니다"
}

@Preview
@Composable
private fun HomeScreenPreview() {
    SOPKATHONTheme {
        HomeScreen()
    }
}
