package com.ponchikchik.logger.di.repository

import com.ponchikchik.logger.di.service.AmwayStartService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiRepository {
    private const val BASE_URL = "https://logger.amway.dev.unit6.ru/logger/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val amwayStartService: AmwayStartService = getRetrofit().create(AmwayStartService::class.java)
}