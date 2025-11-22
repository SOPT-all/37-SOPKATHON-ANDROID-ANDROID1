package com.sopt.sopkathon_android1.presentation.community

import androidx.lifecycle.ViewModel
import com.sopt.sopkathon_android1.domain.repository.CoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CommunityViewModel @Inject constructor(
    private val coreRepository: CoreRepository
) : ViewModel() {



}