package com.tengizmkcorp.food_delivery.di

import com.tengizmkcorp.food_delivery.data.repository.FoodRepositoryImpl
import com.tengizmkcorp.food_delivery.domain.repository.FoodRepository
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
    abstract fun bindMyRepository(
        myRepositoryImpl: FoodRepositoryImpl
    ): FoodRepository
}