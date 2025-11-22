package com.sopt.sopkathon_android1.presentation.community

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.sopkathon_android1.data.dto.info.BalanceGameInfo
import com.sopt.sopkathon_android1.domain.repository.CoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommunityViewModel @Inject constructor(
    private val coreRepository: CoreRepository
) : ViewModel() {

    private val _balanceGameList = MutableStateFlow<List<BalanceGameInfo>>(emptyList())
    val balanceGameList = _balanceGameList.asStateFlow()



    fun getAllBalanceGame(category: String) = viewModelScope.launch {
        val result = coreRepository.getAllBalanceGame(category)

        if(result.isSuccessful) {
            result.body()?.let {
                _balanceGameList.emit(it.result.balanceGames)
            }
        }
    }
}