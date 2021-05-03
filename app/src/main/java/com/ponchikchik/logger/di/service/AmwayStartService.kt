package com.ponchikchik.logger.di.service

import com.ponchikchik.logger.di.model.Log
import retrofit2.http.GET

interface AmwayStartService {
    @GET("all")
    suspend fun getLogs(): List<Log>
}