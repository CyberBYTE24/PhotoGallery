package com.cyberbyte.photogallery.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Src(
    @SerializedName("original")
    @Expose
    val original: String?
)
