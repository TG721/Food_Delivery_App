package com.tengizmkcorp.food_delivery.data.remote

import com.tengizmkcorp.food_delivery.data.remote.model.Discover
import retrofit2.Response
import retrofit2.http.GET

interface FoodApi {
    @GET("ba4a56fe-9996-456a-8dbd-dd39f7cbe2f9")
    suspend fun getDiscoverList(): Response<Discover>
}