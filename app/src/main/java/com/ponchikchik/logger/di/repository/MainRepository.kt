package com.ponchikchik.logger.di.repository

import com.ponchikchik.logger.utils.ApiHelper
import java.util.*

class MainRepository(private val apiService: ApiHelper) {
    suspend fun getAllLogs() = apiService.getLogs()

    suspend fun getLogByTraceId(traceId: UUID) = apiService.getLogByTraceId(traceId)
}