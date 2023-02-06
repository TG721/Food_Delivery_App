package com.tengizmkcorp.food_delivery.domain.repository

import com.tengizmkcorp.food_delivery.data.remote.model.Discover
import com.tengizmkcorp.food_delivery.utils.ResponseState
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
    //retrofit
    suspend fun getDiscoverList(): Flow<ResponseState<Discover>>
}