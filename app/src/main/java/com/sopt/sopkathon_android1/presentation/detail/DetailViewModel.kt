package com.sopt.sopkathon_android1.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.sopkathon_android1.data.dto.info.BalanceGameInfo
import com.sopt.sopkathon_android1.data.dto.info.CommentInfo
import com.sopt.sopkathon_android1.data.dto.request.LikeRequest
import com.sopt.sopkathon_android1.data.dto.request.WriteCommentRequest
import com.sopt.sopkathon_android1.domain.repository.CoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val coreRepository: CoreRepository
) : ViewModel() {

    private val _todayBalanceGame = MutableStateFlow<BalanceGameInfo?>(null)
    val todayBalanceGame = _todayBalanceGame.asStateFlow()

    private val _commentList = MutableStateFlow<List<CommentInfo>>(emptyList())
    val commentList = _commentList.asStateFlow()

    private val _writeCommentSuccess = MutableSharedFlow<Boolean>()
    val writeCommentSuccess = _writeCommentSuccess.asSharedFlow()



    fun getTodayBalanceGame() = viewModelScope.launch {
        val result = coreRepository.getTodayBalanceGame()

        if(result.isSuccessful) {
            result.body()?.let {
                _todayBalanceGame.emit(it.result)
            }
        }
    }

    fun likeBalanceGame(balanceGameId: Int, isLike: Boolean) = viewModelScope.launch {
        coreRepository.likeBalanceGame(balanceGameId, LikeRequest(isLike))
    }

    fun getCommentList(balanceGameId: Int) = viewModelScope.launch {
        val result = coreRepository.getComments(balanceGameId)

        if(result.isSuccessful) {
            result.body()?.let {
                val list = it.result.getCommentResponseDto.subList(0, 4)
                _commentList.emit(list)
                _writeCommentSuccess.emit(false)
            }
        }
    }

    fun writeComment(balanceGameId: Int, content: String) = viewModelScope.launch {
        val result = coreRepository.writeComment(balanceGameId, WriteCommentRequest(content))

        if(result.isSuccessful) {
            _writeCommentSuccess.emit(true)
        }
    }
}