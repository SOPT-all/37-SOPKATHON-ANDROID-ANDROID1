package com.sopt.sopkathon_android1.presentation.profile

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
class ProfileViewModel @Inject constructor(
    private val coreRepository: CoreRepository
) : ViewModel(){

    private val _participatedBalanceGames = MutableStateFlow<List<BalanceGameInfo>>(emptyList())
    val participatedBalanceGames = _participatedBalanceGames.asStateFlow()

    fun getParticipatedBalanceGames() = viewModelScope.launch {
        val result = coreRepository.getParticipatedBalanceGame()

        if(result.isSuccessful) {
            result.body()?.let {
                _participatedBalanceGames.emit(it.result.balanceGameList)
            }
        }
    }
}