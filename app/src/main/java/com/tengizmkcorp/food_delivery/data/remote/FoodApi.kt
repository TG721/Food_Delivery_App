package com.tengizmkcorp.food_delivery.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface FoodApi {
    @GET("489e1253-d414-4334-92bf-67562efe5ac5")
    suspend fun getDiscoverList(): Response<List<BestSalesSortedByNewestItem>>
}