package com.sopt.sopkathon_android1.core.di

import com.sopt.sopkathon_android1.data.service.CoreService
import com.sopt.sopkathon_android1.data.service.DummyService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideDummyApi(retrofit: Retrofit): DummyService = retrofit.create(DummyService::class.java)

    @Provides
    @Singleton
    fun provideCoreApi(retrofit: Retrofit): CoreService = retrofit.create(CoreService::class.java)
}