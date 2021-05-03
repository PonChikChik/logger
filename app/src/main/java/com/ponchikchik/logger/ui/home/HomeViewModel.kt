package com.ponchikchik.logger.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ponchikchik.logger.di.model.Log
import com.ponchikchik.logger.di.repository.ApiRepository
import com.ponchikchik.logger.di.repository.MainRepository
import com.ponchikchik.logger.di.service.AmwayStartService
import com.ponchikchik.logger.utils.Resource
import com.squareup.okhttp.Dispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import java.lang.Exception

class HomeViewModel(private var mainRepository: MainRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun getAllLogs() = liveData(IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getAllLogs()))
        } catch (exception: Exception) {
            emit(Resource.error(null, exception.message ?: "Error Occurred!"))
        }
    }
}