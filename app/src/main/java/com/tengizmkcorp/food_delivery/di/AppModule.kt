package com.tengizmkcorp.food_delivery.di

import android.content.Context
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val client = OkHttpClient.Builder().apply {
        readTimeout(10, TimeUnit.SECONDS)
        addInterceptor(MyInterceptor())
    }.build()

    @Provides
    @Singleton
    fun provideRetrofit(@ApplicationContext context: Context): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://mocki.io/v1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMyApi(retrofit: Retrofit): FoodApi {
        return retrofit.create(FoodApi::class.java)
    }


}