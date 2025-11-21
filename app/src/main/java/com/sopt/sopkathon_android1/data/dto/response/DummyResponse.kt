package com.sopt.sopkathon_android1.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DummyResponse (
    @SerialName("data")
    val data: String
)