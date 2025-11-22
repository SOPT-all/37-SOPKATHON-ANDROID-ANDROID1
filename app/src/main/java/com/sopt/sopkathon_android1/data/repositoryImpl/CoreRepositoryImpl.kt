package com.sopt.sopkathon_android1.data.repositoryImpl

import com.sopt.sopkathon_android1.data.dto.base.BaseResponse
import com.sopt.sopkathon_android1.data.dto.info.BalanceGameInfo
import com.sopt.sopkathon_android1.data.dto.request.LikeRequest
import com.sopt.sopkathon_android1.data.dto.request.VoteBalanceGameRequest
import com.sopt.sopkathon_android1.data.dto.request.WriteCommentRequest
import com.sopt.sopkathon_android1.data.dto.response.BalanceGameAllResponse
import com.sopt.sopkathon_android1.data.dto.response.CommentResponse
import com.sopt.sopkathon_android1.data.dto.response.ParticipatedBalanceGameResponse
import com.sopt.sopkathon_android1.data.dto.response.ParticipatingBalanceGameResponse
import com.sopt.sopkathon_android1.data.service.CoreService
import com.sopt.sopkathon_android1.domain.repository.CoreRepository
import retrofit2.Response
import javax.inject.Inject

class CoreRepositoryImpl @Inject constructor(
    private val coreService: CoreService
) : CoreRepository{
    override suspend fun getTodayBalanceGame(): Response<BaseResponse<BalanceGameInfo>> {
        return coreService.getTodayBalanceGame()
    }

    override suspend fun getHotBalanceGame(): Response<BaseResponse<List<BalanceGameInfo>>> {
        return coreService.getHotBalanceGame()
    }

    override suspend fun getParticipatingBalanceGame(): Response<BaseResponse<ParticipatingBalanceGameResponse>> {
        return coreService.getParticipatingBalanceGame()
    }

    override suspend fun getBalanceGameInfo(balanceGameId: Int): Response<BaseResponse<BalanceGameInfo>> {
        return coreService.getBalanceGameInfo(balanceGameId)
    }

    override suspend fun writeComment(
        balanceGameId: Int,
        writeCommentRequest: WriteCommentRequest
    ): Response<Unit> {
        return coreService.writeComment(balanceGameId, writeCommentRequest)
    }

    override suspend fun getComments(balanceGameId: Int): Response<BaseResponse<CommentResponse>> {
        return coreService.getComments(balanceGameId)
    }

    override suspend fun likeBalanceGame(
        balanceGameId: Int,
        likeRequest: LikeRequest
    ): Response<Unit> {
        return coreService.likeBalanceGame(balanceGameId, likeRequest)
    }

    override suspend fun getParticipatedBalanceGame(): Response<BaseResponse<ParticipatedBalanceGameResponse>> {
        return coreService.getParticipatedBalanceGame()
    }

    override suspend fun voteBalanceGame(
        balanceGameId: Int,
        voteBalanceGameRequest: VoteBalanceGameRequest
    ): Response<Unit> {
        return coreService.voteBalanceGame(balanceGameId, voteBalanceGameRequest)
    }

    override suspend fun getAllBalanceGame(category: String): Response<BaseResponse<BalanceGameAllResponse>> {
        return coreService.getAllBalanceGame(category)
    }
}