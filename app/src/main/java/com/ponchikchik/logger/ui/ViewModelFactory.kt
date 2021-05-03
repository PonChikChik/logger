package com.ponchikchik.logger.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ponchikchik.logger.di.repository.MainRepository
import com.ponchikchik.logger.ui.home.HomeViewModel
import com.ponchikchik.logger.utils.ApiHelper

class ViewModelFactory(private val apiHelper: ApiHelper): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}