package com.cyberbyte.photogallery.ui.adapter

import com.cyberbyte.photogallery.model.Photo

// Provide handle events of photo items
interface PhotoListener {
    fun onPhotoClicked(photo: Photo)
}
