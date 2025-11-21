package com.sopt.sopkathon_android1.data.service

import com.sopt.sopkathon_android1.data.dto.base.BaseResponse
import com.sopt.sopkathon_android1.data.dto.request.DummyRequest
import com.sopt.sopkathon_android1.data.dto.response.DummyResponse
import retrofit2.http.Body
import retrofit2.http.GET

interface DummyService {
    @GET("dummy")
    suspend fun dummyService(@Body dummyRequest: DummyRequest) : BaseResponse<DummyResponse>
}