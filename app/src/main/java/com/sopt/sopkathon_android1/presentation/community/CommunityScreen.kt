package com.sopt.sopkathon_android1.presentation.community

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sopt.sopkathon_android1.core.designsystem.component.SopkathonTopappbar
import com.sopt.sopkathon_android1.core.designsystem.theme.SopkathonTheme
import com.sopt.sopkathon_android1.data.dto.info.BalanceGameInfo


enum class CategoryType(val title: String) {
    LOVE("연애"),
    STUDY("학업"),
    HUMOR("유머"),
    ETC("기타"),
    NONE("")
}

@Composable
fun CommunityScreen(
    modifier: Modifier = Modifier,
    viewModel: CommunityViewModel = hiltViewModel()
) {
    var selectedTab by remember { mutableStateOf<CategoryType?>(null) }

    var balanceGameList by remember { mutableStateOf<List<BalanceGameInfo>>(emptyList()) }

    LaunchedEffect(Unit) {
        viewModel.getAllBalanceGame("")

        viewModel.balanceGameList.collect {
            balanceGameList = it
        }
    }


    Column (
        modifier = modifier
            .fillMaxWidth()
            .systemBarsPadding()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SopkathonTopappbar(
            title = "밸런스 광장",
        )

        Spacer(Modifier.height(18.dp))

        CommunityTabbar(
            selectedTab = selectedTab?.title,
            onTabSelected = { title ->
                var category = ""

                when(title) {
                    "연애" -> {
                        category = "LOVE"
                        selectedTab = CategoryType.LOVE
                    }
                    "유머" -> {
                        category = "HUMOR"
                        selectedTab = CategoryType.HUMOR
                    }
                    "학업" -> {
                        category = "STUDY"
                        selectedTab = CategoryType.STUDY
                    }
                    "기타" -> {
                        category = "ETC"
                        selectedTab = CategoryType.ETC
                    }
                    else -> {
                        category = ""
                        selectedTab = CategoryType.NONE
                    }
                }
                viewModel.getAllBalanceGame(category)
            }
        )

        Spacer(Modifier.height(22.dp))

        CommunityBalance(
            balances = balanceGameList
        )
    }
}