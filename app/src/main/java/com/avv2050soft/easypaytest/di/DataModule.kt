package com.avv2050soft.easypaytest.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
//    @Provides
//    @Singleton
//    fun provideNetworkRepository(): NetworkRepository {
//        return NetworkRepositoryImpl(mapper = RetrofitMapper())
//    }
}