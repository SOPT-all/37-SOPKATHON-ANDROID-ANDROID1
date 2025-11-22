package com.sopt.sopkathon_android1.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// 좋아요 누르기(상태 변경) API Response
@Serializable
data class LikeRequest(
    @SerialName("isLike")
    val isLike: Boolean
)
