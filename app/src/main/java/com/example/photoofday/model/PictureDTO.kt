package com.example.photoofday.model

import com.google.gson.annotations.SerializedName

//Data transfer object - объект передачи данных
data class PictureDto(
    //авторское право
    @field:SerializedName("copyright")
    val copyright: String?,
    //Дата изображения
    val date: String,
    //объяснение (описание)
    val explanation: String,
    //ссылка на картинку
    val hdurl: String,
    //тип: картинка
    @SerializedName("media_type")
    val mediaType: String?,
    @SerializedName("service_version")
    val serviceVersion: String,
    val title: String,
    val url: String,
) {
    val isImage: Boolean get() = mediaType?.equals("image") == true
}