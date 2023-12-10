package com.gall.msu.nasagallery

import com.gall.msu.nasagallery.api.NasaApi
import com.gall.msu.nasagallery.api.GalleryItem
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class PhotoRepository {
    private val flickrApi: NasaApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        flickrApi = retrofit.create()
    }

    suspend fun fetchPhotos(count: Int): List<GalleryItem> =
        flickrApi.fetchPhotos(count).photos.galleryItems
}
