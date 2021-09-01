package com.example.photoofday.repository

import com.example.photoofday.BuildConfig
import com.example.photoofday.model.PictureDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//запрос на сервер — запрос на фото дня


interface PictureOfTheDayApi {

    @GET("planetary/apod?api_key=${BuildConfig.NASA_API_KEY}")
    fun getPictureOfTheDay(
        @Query("date") date: String = RemoteDataSource.getToday(),
    ): Call<PictureDTO>
}