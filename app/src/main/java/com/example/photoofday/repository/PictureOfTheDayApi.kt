package com.example.PhotoOfDay.repository


import com.example.PhotoOfDay.BuildConfig
import com.example.PhotoOfDay.model.PictureDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface PictureOfTheDayApi {

    @GET("planetary/apod?api_key=${BuildConfig.NASA_API_KEY}")
    fun getPictureOfTheDay(
        @Query("date") date: String = RemoteNasaDataSource.getTodayDayString(),
    ): Call<PictureDto>
}
