package com.example.photoofday.repository

import com.example.photoofday.BuildConfig
import com.example.photoofday.model.PictureDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query



interface PictureOfTheDayApi {

    @GET("planetary/apod?api_key=${BuildConfig.NASA_API_KEY}")
    fun getPictureOfTheDay(
        @Query("date") date: String = RemoteNasaDataSource.getTodayDayString(),
    ): Call<PictureDto>
}