package com.ponchikchik.logger.di.service

import com.ponchikchik.logger.di.model.Log
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import java.util.*

interface AmwayStartService {
    @Headers("Content-Type: application/json")
    @GET("all")
    suspend fun getLogs(): List<Log>

    @Headers("Content-Type: application/json")
    @GET("trace-log")
    suspend fun getLogByTraceId(@Query("traceId") traceId: UUID): Log
}