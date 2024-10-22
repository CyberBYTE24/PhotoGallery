package com.cyberbyte.photogallery.service

import com.cyberbyte.photogallery.model.Photo

// Provide data managing for app
class PhotoGalleryDataService(
    // Retrofit implemented interface for remote REST-API
    private val photoGalleryApiService: PhotoGalleryApiService
) {

    // Get photos from remote REST-API
    suspend fun fetchPhotos(): List<Photo>{
        return photoGalleryApiService.getPhotos().photos
    }
}