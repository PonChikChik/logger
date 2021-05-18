package com.ponchikchik.logger.ui.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.ponchikchik.logger.di.network.NetworkStatusTracker
import com.ponchikchik.logger.di.network.map
import com.ponchikchik.logger.di.repository.MainRepository
import com.ponchikchik.logger.utils.Resource
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.lang.Exception
import java.util.*

sealed class NetworkState {
    object Fetched : NetworkState()
    object Error : NetworkState()
}

class NetworkStatusViewModel(networkStatusTracker: NetworkStatusTracker) : ViewModel() {
    @ExperimentalCoroutinesApi
    val state =
        networkStatusTracker.networkStatus
            .map(
                onUnavailable = { NetworkState.Error },
                onAvailable = { NetworkState.Fetched },
            )
            .asLiveData(IO)
}