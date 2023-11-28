package com.avv2050soft.easypaytest.di

import com.avv2050soft.easypaytest.data.network.retrofit.mappers.RetrofitMapper
import com.avv2050soft.easypaytest.data.network.retrofit.repository.NetworkRepositoryImpl
import com.avv2050soft.easypaytest.domain.repository.NetworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideNetworkRepository(): NetworkRepository {
        return NetworkRepositoryImpl(mapper = RetrofitMapper())
    }
}