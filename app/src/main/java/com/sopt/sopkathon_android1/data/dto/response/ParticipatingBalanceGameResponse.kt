package com.sopt.sopkathon_android1.data.dto.response

import com.sopt.sopkathon_android1.data.dto.info.BalanceGameInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// 내가 참여중인 밸런스 게임(마감x) 조회 API Response
@Serializable
data class ParticipatingBalanceGameResponse (
    @SerialName("balanceGameList")
    val balanceGameList: List<BalanceGameInfo>
)