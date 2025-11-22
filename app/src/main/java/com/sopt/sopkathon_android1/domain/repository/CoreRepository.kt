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
    fun getTodayBalanceGame() : Response<BaseResponse<BalanceGameInfo>>
    fun getHotBalanceGame() : Response<BaseResponse<BalanceGameInfo>>
    fun getParticipatingBalanceGame() : Response<BaseResponse<ParticipatingBalanceGameResponse>>
    fun getBalanceGameInfo(balanceGameId: Int) : Response<BaseResponse<BalanceGameInfo>>
    fun writeComment(balanceGameId: Int, writeCommentRequest: WriteCommentRequest) : Response<BaseResponse<Unit>>
    fun getComments(balanceGameId: Int) : Response<BaseResponse<CommentResponse>>
    fun likeBalanceGame(balanceGameId: Int, likeRequest: LikeRequest) : Response<BaseResponse<Unit>>
    fun getParticipatedBalanceGame() : Response<BaseResponse<ParticipatedBalanceGameResponse>>
    fun voteBalanceGame(balanceGameId: Int, voteBalanceGameRequest: VoteBalanceGameRequest) : Response<BaseResponse<Unit>>
    fun getAllBalanceGame(category: String) : Response<BaseResponse<BalanceGameAllResponse>>
}