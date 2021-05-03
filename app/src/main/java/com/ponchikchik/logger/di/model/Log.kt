package com.ponchikchik.logger.di.model

import com.google.gson.annotations.SerializedName
import com.ponchikchik.logger.utils.LogType
import java.time.LocalDateTime
import java.util.*

data class Log(
    @SerializedName("clientId")
    val clientId: UUID,
    @SerializedName("appVersion")
    val appVersion: Int,
    @SerializedName("logType")
    val logType: LogType,
    @SerializedName("logMessage")
    val logMessage: String,
    @SerializedName("deviceId")
    val deviceId: String,
    @SerializedName("screenName")
    val screenName: String,
    @SerializedName("brandName")
    val brandName: String,
    @SerializedName("modelName")
    val modelName: String,
    @SerializedName("osVersion")
    val osVersion: String,
    @SerializedName("traceId")
    val traceId: UUID,
    @SerializedName("createdAt")
    val createdAt: LocalDateTime
)
