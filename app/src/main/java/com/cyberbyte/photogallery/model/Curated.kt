package com.cyberbyte.photogallery.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Curated(
    @SerializedName("photos")
    @Expose
    val photos: List<Photo>
)
