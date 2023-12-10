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
            .baseUrl("https://api.flickr.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        flickrApi = retrofit.create()
    }

//    suspend fun fetchPhotos(): List<GalleryItem> =
//        flickrApi.fetchPhotos().photos.galleryItems

    suspend fun fetchPhotos(page: Int, pageSize: Int): List<GalleryItem> =
        flickrApi.fetchPhotos(page, pageSize).photos.galleryItems
}
