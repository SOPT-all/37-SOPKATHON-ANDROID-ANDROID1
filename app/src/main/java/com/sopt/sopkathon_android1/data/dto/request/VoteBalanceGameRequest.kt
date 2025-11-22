package com.sopt.sopkathon_android1.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// 밸런스 게임 투표 API Request
@Serializable
data class VoteBalanceGameRequest(
    @SerialName("option")
    val option: String
)