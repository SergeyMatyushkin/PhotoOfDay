package com.example.photoofday.model

import com.google.gson.annotations.SerializedName

data class PictureDTO(
    //авторское право
    @field:SerializedName("copyright")
    val copyright: String?,
    //Дата изображения картинки дня
    val date: String,
    //описание будет загружаться в bottomSheet
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