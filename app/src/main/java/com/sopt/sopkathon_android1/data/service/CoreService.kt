package com.sopt.sopkathon_android1.data.service

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
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface CoreService {
    @GET("api/v1/balance-games/today")
    fun getTodayBalanceGame() : Response<BaseResponse<BalanceGameInfo>>

    @GET("api/v1/balance-games/hot")
    fun getHotBalanceGame() : Response<BaseResponse<BalanceGameInfo>>

    @GET("api/v1/balance-games/current-participants")
    fun getParticipatingBalanceGame() : Response<BaseResponse<ParticipatingBalanceGameResponse>>

    @GET("api/v1/balance-games/{balanceGameId}")
    fun getBalanceGameInfo(@Path("balanceGameId") balanceGameId: Int) : Response<BaseResponse<BalanceGameInfo>>

    @POST("api/v1/balance-games/{balanceGameId}/comments")
    fun writeComment(@Path("balanceGameId") balanceGameId: Int, @Body writeCommentRequest: WriteCommentRequest) : Response<BaseResponse<Unit>>

    @GET("api/v1/balance-games/{balanceGameId}/comments")
    fun getComments(@Path("balanceGameId") balanceGameId: Int) : Response<BaseResponse<CommentResponse>>

    @POST("api/v1/banace-games/{balanceGameId}/likes")
    fun likeBalanceGame(@Path("balanceGameId") balanceGameId: Int, @Body likeRequest: LikeRequest) : Response<BaseResponse<Unit>>

    @GET("api/v1/balance-games/past-participants")
    fun getParticipatedBalanceGame() : Response<BaseResponse<ParticipatedBalanceGameResponse>>

    @POST("api/v1/balance-games/{balanceGameId}")
    fun voteBalanceGame(@Path("balanceGameId") balanceGameId: Int, @Body voteBalanceGameRequest: VoteBalanceGameRequest) : Response<BaseResponse<Unit>>

    @GET("api/v1/balance-games?category")
    fun getAllBalanceGame(@Query("category") category: String) : Response<BaseResponse<BalanceGameAllResponse>>

}