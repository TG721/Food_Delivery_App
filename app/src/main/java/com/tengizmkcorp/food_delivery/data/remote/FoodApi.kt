package com.tengizmkcorp.food_delivery.data.remote

import com.tengizmkcorp.food_delivery.data.remote.model.Discover
import retrofit2.Response
import retrofit2.http.GET

interface FoodApi {
    @GET("0fd8f30d-d729-4dc5-b59e-d51c92937e31")
    suspend fun getDiscoverList(): Response<Discover>
}