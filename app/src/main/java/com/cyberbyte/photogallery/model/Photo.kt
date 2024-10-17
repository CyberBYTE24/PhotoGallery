package com.cyberbyte.photogallery.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id")
    @Expose
    val id: Int?,

    @SerializedName("photographer")
    @Expose
    val photographer: String?,

    @SerializedName("src")
    @Expose
    val src: Src?
)
