package com.sopt.sopkathon_android1.data.dto.response

import com.sopt.sopkathon_android1.data.dto.info.BalanceGameInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ParticipatedBalanceGameResponse(
    @SerialName("balanceGames")
    val balanceGameList: List<BalanceGameInfo>
)











