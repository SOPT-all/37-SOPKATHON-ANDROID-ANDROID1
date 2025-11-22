package com.sopt.sopkathon_android1.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WriteCommentRequest(
    @SerialName("content")
    val content: String
)
