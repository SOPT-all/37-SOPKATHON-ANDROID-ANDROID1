package com.sopt.sopkathon_android1.data.dto.response

import com.sopt.sopkathon_android1.data.dto.info.CommentInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// 댓글 보기 API Response
@Serializable
data class CommentResponse(
    @SerialName("getCommentResponseDto")
    val getCommentResponseDto: List<CommentInfo>
)
