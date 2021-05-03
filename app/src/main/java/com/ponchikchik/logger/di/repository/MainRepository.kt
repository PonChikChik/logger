package com.ponchikchik.logger.di.repository

import com.ponchikchik.logger.utils.ApiHelper

class MainRepository(private val apiService: ApiHelper) {
    suspend fun getAllLogs() = apiService.getUsers()
}