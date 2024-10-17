package com.cyberbyte.photogallery.ui.adapter

import com.cyberbyte.photogallery.model.Photo

interface PhotoListener {
    fun onPhotoClicked(photo: Photo)
}