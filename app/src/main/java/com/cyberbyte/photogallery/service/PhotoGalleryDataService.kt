package com.cyberbyte.photogallery.service

import com.cyberbyte.photogallery.model.Photo

class PhotoGalleryDataService(
    private val photoGalleryApiService: PhotoGalleryApiService
) {
    suspend fun fetchPhotos(): List<Photo>{
        return photoGalleryApiService.getPhotos().photos
    }
}