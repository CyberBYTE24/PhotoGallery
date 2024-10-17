package com.cyberbyte.photogallery.usecase

import com.cyberbyte.photogallery.model.Photo
import com.cyberbyte.photogallery.service.PhotoGalleryDataService

class GetRemotePhotoGalleryUseCase(
    private val photoGalleryDataService: PhotoGalleryDataService
) {
    suspend fun invoke(): List<Photo>{
        return photoGalleryDataService.fetchPhotos()
    }
}