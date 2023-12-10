package com.gall.msu.nasagallery.api

import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "8a9c8c2f518267c7c1ad2b96079c6688"

interface NasaApi {
    @GET("planetary/aprod?" +
            "api_key=$API_KEY")
    suspend fun fetchPhotos(
        @Query("count") count: Int,
    ): NasaResponse

}
