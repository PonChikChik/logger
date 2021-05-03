package com.ponchikchik.logger.utils

import com.ponchikchik.logger.di.service.AmwayStartService

class ApiHelper(private val apiService: AmwayStartService) {

    suspend fun getUsers() = apiService.getLogs()
}