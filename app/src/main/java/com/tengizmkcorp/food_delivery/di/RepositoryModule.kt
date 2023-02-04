package com.tengizmkcorp.food_delivery.di

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMyRepository(
        myRepositoryImpl: StoreRepositoryImpl
    ): StoreRepository
}