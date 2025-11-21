package com.sopt.sopkathon_android1.core.di

import com.sopt.sopkathon_android1.data.repositoryImpl.DummyRepositoryImpl
import com.sopt.sopkathon_android1.domain.repository.DummyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindDummyRepository(dummyRepositoryImpl: DummyRepositoryImpl): DummyRepository
}