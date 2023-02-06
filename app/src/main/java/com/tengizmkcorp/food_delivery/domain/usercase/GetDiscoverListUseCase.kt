package com.tengizmkcorp.food_delivery.domain.usercase

import com.tengizmkcorp.food_delivery.data.remote.model.Discover
import com.tengizmkcorp.food_delivery.domain.repository.FoodRepository
import com.tengizmkcorp.food_delivery.utils.ResponseState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDiscoverListUseCase @Inject constructor(
    private val foodRep: FoodRepository,
) {
    suspend fun getDiscoverList(): Flow<ResponseState<Discover>> {
        return foodRep.getDiscoverList()
    }
}