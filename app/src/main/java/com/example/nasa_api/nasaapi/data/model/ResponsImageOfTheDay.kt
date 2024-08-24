package com.example.nasa_api.nasaapi.data.model


import com.squareup.moshi.Json

data class ResponsImageOfTheDay(
    @Json(name = "copyright")
    val copyright: String? = null,
    @Json(name = "date")
    val date: String? = null,
    @Json(name = "explanation")
    val explanation: String? = null,
    @Json(name = "hdurl")
    val hdurl: String? = null,
    @Json(name = "media_type")
    val mediaType: String? = null,
    @Json(name = "service_version")
    val serviceVersion: String? = null,
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "url")
    val url: String? = null
)