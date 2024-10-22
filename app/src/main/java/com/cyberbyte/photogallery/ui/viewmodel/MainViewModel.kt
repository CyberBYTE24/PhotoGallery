package com.cyberbyte.photogallery.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyberbyte.photogallery.model.Photo
import com.cyberbyte.photogallery.usecase.GetRemotePhotoGalleryUseCase
import kotlinx.coroutines.launch

// View Model for Main Activity
class MainViewModel(
    // Use case for Getting photos and metadata from remote REST-API
    private val getRemotePhotoGalleryUseCase: GetRemotePhotoGalleryUseCase
) : ViewModel() {

    // List of photos
    private val _photos = MutableLiveData<MutableList<Photo>>()
    val photos: LiveData<MutableList<Photo>> get() = _photos

    // Start getting photos from remote REST-API by UseCase
    fun loadPhotos(){
        viewModelScope.launch {
            _photos.value = getRemotePhotoGalleryUseCase.invoke().toMutableList()
        }
    }
}