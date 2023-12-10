package com.gall.msu.nasagallery

import androidx.paging.PageKeyedDataSource
import com.gall.msu.nasagallery.api.GalleryItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class PhotoDataSource(
    private val scope: CoroutineScope,
    private val repository: PhotoRepository
) : PageKeyedDataSource<Int, GalleryItem>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, GalleryItem>
    ) {
        scope.launch {
            try {
                val count = 1 // Initial page
                val photos = repository.fetchPhotos(count)
                callback.onResult(photos, null, count + 1)
            } catch (ex: Exception) {
                // Handle exception
            }
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, GalleryItem>
    ) {
        scope.launch {
            try {
                val count = params.key
                val photos = repository.fetchPhotos(count)
                callback.onResult(photos, count + 1)
            } catch (ex: Exception) {
                // Handle exception
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, GalleryItem>) {
        TODO("Not yet implemented")
    }

}

