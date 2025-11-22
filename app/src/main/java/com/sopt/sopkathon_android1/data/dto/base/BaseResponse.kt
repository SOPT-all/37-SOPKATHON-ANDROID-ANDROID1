package com.sopt.sopkathon_android1.data.dto.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T> (
    @SerialName("message")
    val message: String,
    @SerialName("result")
    val result: T
)
