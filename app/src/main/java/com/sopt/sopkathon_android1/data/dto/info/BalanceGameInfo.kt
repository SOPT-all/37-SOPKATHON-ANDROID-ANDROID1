package com.sopt.sopkathon_android1.data.dto.info

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BalanceGameInfo (
    @SerialName("balance_game_id")
    val balanceGameId: Int,
    @SerialName("title")
    val title: String,
    @SerialName("option1Title")
    val option1Title: String,
    @SerialName("option2Title")
    val option2Title: String,
    @SerialName("isLike")
    val isLike: Boolean,
    @SerialName("memberOption")
    val memberOption: String,
    @SerialName("option1Total")
    val option1Total: Int,
    @SerialName("option2Total")
    val option2Total: Int,
    @SerialName("deadline")
    val deadline: String,
    @SerialName("category")
    val category: String,
)