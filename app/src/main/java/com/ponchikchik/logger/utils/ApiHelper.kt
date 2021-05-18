package com.ponchikchik.logger.utils

import com.ponchikchik.logger.di.service.AmwayStartService
import java.util.*

class ApiHelper(private val apiService: AmwayStartService) {

    suspend fun getLogs() = apiService.getLogs()

    suspend fun getLogByTraceId(traceId: UUID) = apiService.getLogByTraceId(traceId)
}