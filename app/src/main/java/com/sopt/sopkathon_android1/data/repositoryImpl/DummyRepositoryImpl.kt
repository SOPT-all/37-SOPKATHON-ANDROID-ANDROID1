package com.sopt.sopkathon_android1.data.repositoryImpl

import com.sopt.sopkathon_android1.data.dto.base.BaseResponse
import com.sopt.sopkathon_android1.data.dto.request.DummyRequest
import com.sopt.sopkathon_android1.data.dto.response.DummyResponse
import com.sopt.sopkathon_android1.data.service.DummyService
import com.sopt.sopkathon_android1.domain.repository.DummyRepository
import javax.inject.Inject

class DummyRepositoryImpl @Inject constructor(
    private val dummyService: DummyService
) : DummyRepository {
    override suspend fun dummy(dummyRequest: DummyRequest): BaseResponse<DummyResponse> {
        return dummyService.dummyService(dummyRequest)
    }
}