package com.cyberbyte.photogallery.ui.adapter

import androidx.recyclerview.widget.ListAdapter
import com.cyberbyte.photogallery.model.Photo

class MovieAdapter(private var photos: List<Photo>, private var movieListener: PhotoListener) : ListAdapter<Photo, PhotoAdapter.PhotoViewHolder>(
    PhotoDiffCallback()
)  {

}