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
    suspend fun getTodayBalanceGame() : Response<BaseResponse<BalanceGameInfo>>

    @GET("api/v1/balance-games/hot")
    suspend fun getHotBalanceGame() : Response<BaseResponse<List<BalanceGameInfo>>>

    @GET("api/v1/balance-games/current-participants")
    suspend fun getParticipatingBalanceGame() : Response<BaseResponse<ParticipatingBalanceGameResponse>>

    @GET("api/v1/balance-games/{balanceGameId}")
    suspend fun getBalanceGameInfo(@Path("balanceGameId") balanceGameId: Int) : Response<BaseResponse<BalanceGameInfo>>

    @POST("api/v1/balance-games/{balanceGameId}/comments")
    suspend fun writeComment(@Path("balanceGameId") balanceGameId: Int, @Body writeCommentRequest: WriteCommentRequest) : Response<Unit>

    @GET("api/v1/balance-games/{balanceGameId}/comments")
    suspend fun getComments(@Path("balanceGameId") balanceGameId: Int) : Response<BaseResponse<CommentResponse>>

    @POST("api/v1/balance-games/{balanceGameId}/likes")
    suspend fun likeBalanceGame(@Path("balanceGameId") balanceGameId: Int, @Body likeRequest: LikeRequest) : Response<Unit>

    @GET("api/v1/balance-games/past-participants")
    suspend fun getParticipatedBalanceGame() : Response<BaseResponse<ParticipatedBalanceGameResponse>>

    @POST("api/v1/balance-games/{balanceGameId}")
    suspend fun voteBalanceGame(@Path("balanceGameId") balanceGameId: Int, @Body voteBalanceGameRequest: VoteBalanceGameRequest) : Response<Unit>

    @GET("api/v1/balance-games?category")
    suspend fun getAllBalanceGame(@Query("category") category: String) : Response<BaseResponse<BalanceGameAllResponse>>

}