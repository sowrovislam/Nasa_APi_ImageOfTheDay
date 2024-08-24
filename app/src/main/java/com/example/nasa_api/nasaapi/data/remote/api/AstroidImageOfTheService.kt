package com.example.nasa_api.nasaapi.data.remote.api

import com.example.nasa_api.nasaapi.Constant
import com.example.nasa_api.nasaapi.Constant.API_KEY
import com.example.nasa_api.nasaapi.Constant.BASE_URL
import com.example.nasa_api.nasaapi.data.model.ResponsImageOfTheDay
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface AsteroidImageOfTheDayService {
    @GET("planetary/apod")
    suspend fun getImageOfTheDay(@Query("api_key") apiKey: String = API_KEY):Response<ResponsImageOfTheDay>
}


private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()


object Network {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()


    val ImageOfTheDayService= retrofit.create(AsteroidImageOfTheDayService::class.java)

}