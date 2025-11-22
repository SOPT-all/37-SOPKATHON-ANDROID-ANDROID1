package com.sopt.sopkathon_android1.data.dto.info

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CommentInfo (
    @SerialName("option")
    val option: String,
    @SerialName("content")
    val content: String,
    @SerialName("author")
    val author: String,
    @SerialName("createdAt")
    val createdAt: String
)