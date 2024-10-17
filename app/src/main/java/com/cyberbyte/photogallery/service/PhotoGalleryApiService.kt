package com.cyberbyte.photogallery.service

import com.cyberbyte.photogallery.model.Curated
import retrofit2.http.GET
import retrofit2.http.Headers

interface PhotoGalleryApiService {
    @Headers("Authorization: SWz6yRNgL8HrIrZQ1DFFSeiE8OOUffGYUzCjrr1c4TfR35gve6xH1DkE")
    @GET("curated")
    suspend fun getPhotos(): Curated
}