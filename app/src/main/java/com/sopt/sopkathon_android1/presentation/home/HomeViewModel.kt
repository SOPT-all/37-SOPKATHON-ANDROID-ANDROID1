package com.sopt.sopkathon_android1.presentation.home

import androidx.lifecycle.ViewModel
import com.sopt.sopkathon_android1.domain.repository.DummyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dummyRepository: DummyRepository
) : ViewModel() {

}