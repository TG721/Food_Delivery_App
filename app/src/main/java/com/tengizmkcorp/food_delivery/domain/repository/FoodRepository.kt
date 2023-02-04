package com.tengizmkcorp.food_delivery.domain.repository

import kotlinx.coroutines.flow.Flow

interface FoodRepository {
    //retrofit
    suspend fun getDiscoverList(): Flow<ResponseState<List<BestSalesSortedByNewestItem>>>
}