package com.ponchikchik.logger.ui.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ponchikchik.logger.di.network.NetworkStatusTracker
import com.ponchikchik.logger.di.repository.MainRepository
import com.ponchikchik.logger.utils.ApiHelper

class ViewModelFactory<H>(private val helper: H): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AmwayLoggerViewModel::class.java)) {
            return AmwayLoggerViewModel(MainRepository(helper as ApiHelper)) as T
        }
        if (modelClass.isAssignableFrom(NetworkStatusViewModel::class.java)) {
            return NetworkStatusViewModel(helper as NetworkStatusTracker) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}