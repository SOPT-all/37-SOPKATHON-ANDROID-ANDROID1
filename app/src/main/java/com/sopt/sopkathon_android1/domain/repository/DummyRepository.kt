package com.sopt.sopkathon_android1.domain.repository

import com.sopt.sopkathon_android1.data.dto.base.BaseResponse
import com.sopt.sopkathon_android1.data.dto.request.DummyRequest
import com.sopt.sopkathon_android1.data.dto.response.DummyResponse

interface DummyRepository  {
    suspend fun dummy(dummyRequest: DummyRequest) : BaseResponse<DummyResponse>
}