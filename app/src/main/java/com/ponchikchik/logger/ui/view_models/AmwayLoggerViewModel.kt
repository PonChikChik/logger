package com.ponchikchik.logger.ui.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ponchikchik.logger.di.repository.MainRepository
import com.ponchikchik.logger.utils.Resource
import kotlinx.coroutines.Dispatchers.IO
import java.lang.Exception
import java.util.*

class AmwayLoggerViewModel(private var mainRepository: MainRepository) : ViewModel() {

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

    fun getLogByTraceId(traceId: UUID) = liveData(IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getLogByTraceId(traceId)))
        } catch (exception: Exception) {
            emit(Resource.error(null, exception.message ?: "Error Occurred!"))
        }
    }
}