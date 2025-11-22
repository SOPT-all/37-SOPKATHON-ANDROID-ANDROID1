package com.sopt.sopkathon_android1.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.sopkathon_android1.domain.repository.CoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val coreRepository: CoreRepository
) : ViewModel() {
    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()

    init {
        fetchBalanceGames()
    }

    fun fetchBalanceGames() = viewModelScope.launch {
        val todayDeferred = async { coreRepository.getTodayBalanceGame() }
        val participatingDeferred = async { coreRepository.getParticipatingBalanceGame() }
        val hotDeferred = async { coreRepository.getHotBalanceGame() }

        val todayResponse = todayDeferred.await()
        val participatingResponse = participatingDeferred.await()
        val hotResponse = hotDeferred.await()

        val todayData = if (todayResponse.isSuccessful) todayResponse.body()?.result else null
        val participatingData = if (participatingResponse.isSuccessful) participatingResponse.body()?.result?.balanceGameList else emptyList()
        val hotData = if (hotResponse.isSuccessful) hotResponse.body()?.result else emptyList()

        _homeUiState.update { currentState ->
            currentState.copy(
                todayBalanceGame = todayData,
                participatingBalanceGames = participatingData!!,
                hotBalanceGames = hotData!!,
            )
        }
    }
}