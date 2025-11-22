package com.sopt.sopkathon_android1.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sopt.sopkathon_android1.core.designsystem.component.SopkathonTopappbar
import com.sopt.sopkathon_android1.core.designsystem.theme.SOPKATHONTheme
import com.sopt.sopkathon_android1.core.designsystem.theme.SopkathonTheme
import com.sopt.sopkathon_android1.presentation.profile.component.ProfileCard
import VoteResultComponent
import ResultStatus
import kotlinx.coroutines.delay
import androidx.compose.foundation.layout.statusBarsPadding

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val paddedModifier = Modifier.padding(horizontal = 16.dp)
    val participatedGames by viewModel.participatedBalanceGames.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getParticipatedBalanceGames()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(SopkathonTheme.colors.gray_100)
            .verticalScroll(rememberScrollState())
    ) {
        SopkathonTopappbar("마이페이지")

        Spacer(modifier = Modifier.height(10.dp))

        ProfileCard(modifier = paddedModifier)

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "내가 참여한 밸런스게임",
            style = SopkathonTheme.typography.titleSemiBold16,
            modifier = paddedModifier
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            participatedGames.forEach { game ->
                VoteResultItem(game = game)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun VoteResultItem(game: com.sopt.sopkathon_android1.data.dto.info.BalanceGameInfo) {
    var option1Result by remember { mutableStateOf(ResultStatus.NONE) }
    var option2Result by remember { mutableStateOf(ResultStatus.NONE) }

    // 초기 로드 후 500ms 후에 결과 상태 업데이트 (애니메이션 트리거)
    LaunchedEffect(game.id) {
        delay(500)

        val option1Won = game.option1Total > game.option2Total
        val option2Won = game.option2Total > game.option1Total

        option1Result = when {
            option1Won -> ResultStatus.WIN
            option2Won -> ResultStatus.LOSE
            else -> ResultStatus.NONE
        }

        option2Result = when {
            option2Won -> ResultStatus.WIN
            option1Won -> ResultStatus.LOSE
            else -> ResultStatus.NONE
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {
        VoteResultComponent(
            option1Title = game.option1Title,
            option2Title = game.option2Title,
            option1Total = game.option1Total,
            option2Total = game.option2Total,
            memberOption = game.memberOption,
            option1Result = option1Result,
            option2Result = option2Result
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPreview() {
    SOPKATHONTheme {
        ProfileScreen()
    }
}