package com.sopt.sopkathon_android1.presentation.home

import com.sopt.sopkathon_android1.data.dto.info.BalanceGameInfo

data class HomeUiState(
    val todayBalanceGame: BalanceGameInfo? = null,
    val participatingBalanceGames: List<BalanceGameInfo> = emptyList(),
    val hotBalanceGames: List<BalanceGameInfo> = emptyList()
)
