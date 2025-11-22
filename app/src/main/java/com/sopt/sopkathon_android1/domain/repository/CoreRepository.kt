package com.sopt.sopkathon_android1.domain.repository

import com.sopt.sopkathon_android1.data.dto.base.BaseResponse
import com.sopt.sopkathon_android1.data.dto.info.BalanceGameInfo
import com.sopt.sopkathon_android1.data.dto.request.LikeRequest
import com.sopt.sopkathon_android1.data.dto.request.VoteBalanceGameRequest
import com.sopt.sopkathon_android1.data.dto.request.WriteCommentRequest
import com.sopt.sopkathon_android1.data.dto.response.BalanceGameAllResponse
import com.sopt.sopkathon_android1.data.dto.response.CommentResponse
import com.sopt.sopkathon_android1.data.dto.response.ParticipatedBalanceGameResponse
import com.sopt.sopkathon_android1.data.dto.response.ParticipatingBalanceGameResponse
import retrofit2.Response

interface CoreRepository {
    suspend fun getTodayBalanceGame() : Response<BaseResponse<BalanceGameInfo>>
    suspend fun getHotBalanceGame() : Response<BaseResponse<BalanceGameInfo>>
    suspend fun getParticipatingBalanceGame() : Response<BaseResponse<ParticipatingBalanceGameResponse>>
    suspend fun getBalanceGameInfo(balanceGameId: Int) : Response<BaseResponse<BalanceGameInfo>>
    suspend fun writeComment(balanceGameId: Int, writeCommentRequest: WriteCommentRequest) : Response<Unit>
    suspend fun getComments(balanceGameId: Int) : Response<BaseResponse<CommentResponse>>
    suspend fun likeBalanceGame(balanceGameId: Int, likeRequest: LikeRequest) : Response<Unit>
    suspend fun getParticipatedBalanceGame() : Response<BaseResponse<ParticipatedBalanceGameResponse>>
    suspend fun voteBalanceGame(balanceGameId: Int, voteBalanceGameRequest: VoteBalanceGameRequest) : Response<Unit>
    suspend fun getAllBalanceGame(category: String) : Response<BaseResponse<BalanceGameAllResponse>>
}