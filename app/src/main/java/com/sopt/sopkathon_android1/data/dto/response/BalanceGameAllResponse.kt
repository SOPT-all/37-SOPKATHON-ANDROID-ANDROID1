package com.sopt.sopkathon_android1.data.dto.response

import com.sopt.sopkathon_android1.data.dto.info.BalanceGameInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//밸런스 게임 전체(마감x) 조회
@Serializable
data class BalanceGameAllResponse(
    @SerialName("balanceGameList")
    val balanceGameList: List<BalanceGameInfo>
)
