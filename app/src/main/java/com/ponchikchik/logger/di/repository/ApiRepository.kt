package com.ponchikchik.logger.di.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.*
import com.ponchikchik.logger.di.service.AmwayStartService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import java.time.LocalDateTime

object ApiRepository {
    private const val BASE_URL = "https://logger.amway.dev.unit6.ru/logger/"

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(getGsonBuilder()))
        .build()

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getGsonBuilder(): Gson {
        val builder = GsonBuilder()

        builder.registerTypeAdapter(LocalDateTime::class.java, JsonDeserializer { json, _, _ ->
            LocalDateTime.parse(json.asJsonPrimitive.asString)
        })

        return builder.create()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    val amwayStartService: AmwayStartService = getRetrofit().create(AmwayStartService::class.java)
}