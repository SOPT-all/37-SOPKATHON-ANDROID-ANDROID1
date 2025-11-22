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
    override fun getTodayBalanceGame(): Response<BaseResponse<BalanceGameInfo>> {
        return coreService.getTodayBalanceGame()
    }

    override fun getHotBalanceGame(): Response<BaseResponse<BalanceGameInfo>> {
        return coreService.getHotBalanceGame()
    }

    override fun getParticipatingBalanceGame(): Response<BaseResponse<ParticipatingBalanceGameResponse>> {
        return coreService.getParticipatingBalanceGame()
    }

    override fun getBalanceGameInfo(balanceGameId: Int): Response<BaseResponse<BalanceGameInfo>> {
        return coreService.getBalanceGameInfo(balanceGameId)
    }

    override fun writeComment(
        balanceGameId: Int,
        writeCommentRequest: WriteCommentRequest
    ): Response<BaseResponse<Unit>> {
        return coreService.writeComment(balanceGameId, writeCommentRequest)
    }

    override fun getComments(balanceGameId: Int): Response<BaseResponse<CommentResponse>> {
        return coreService.getComments(balanceGameId)
    }

    override fun likeBalanceGame(
        balanceGameId: Int,
        likeRequest: LikeRequest
    ): Response<BaseResponse<Unit>> {
        return coreService.likeBalanceGame(balanceGameId, likeRequest)
    }

    override fun getParticipatedBalanceGame(): Response<BaseResponse<ParticipatedBalanceGameResponse>> {
        return coreService.getParticipatedBalanceGame()
    }

    override fun voteBalanceGame(
        balanceGameId: Int,
        voteBalanceGameRequest: VoteBalanceGameRequest
    ): Response<BaseResponse<Unit>> {
        return coreService.voteBalanceGame(balanceGameId, voteBalanceGameRequest)
    }

    override fun getAllBalanceGame(category: String): Response<BaseResponse<BalanceGameAllResponse>> {
        return coreService.getAllBalanceGame(category)
    }
}