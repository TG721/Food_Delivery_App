package com.tengizmkcorp.food_delivery.data.repository

import com.tengizmkcorp.food_delivery.data.remote.FoodApi
import com.tengizmkcorp.food_delivery.domain.repository.FoodRepository
import com.tengizmkcorp.food_delivery.utils.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(private val api: FoodApi, private val productDao: ProductDao, private val cartDao: CartDao) :
    FoodRepository {
    //retrofit
    override suspend fun getDiscoverList(): Flow<ResponseState<List<BestSalesSortedByNewestItem>>> =
        flow {
            try {
                val response: Response<List<BestSalesSortedByNewestItem>> =
                    api.getBestSalesProductsSortByNewest()
                val body: List<BestSalesSortedByNewestItem>? = response.body()
                if (response.isSuccessful && body != null) {
                    emit(ResponseState.Success(body))
                } else {
                    emit(ResponseState.Error(response.errorBody()?.string()))
                }
            } catch (e: Exception) {
                emit(ResponseState.Error(e.message.toString()))
            }
        }
}