package com.cyberbyte.photogallery.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyberbyte.photogallery.model.Photo
import com.cyberbyte.photogallery.usecase.GetRemotePhotoGalleryUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getRemotePhotoGalleryUseCase: GetRemotePhotoGalleryUseCase
) : ViewModel() {

    private val _photos = MutableLiveData<MutableList<Photo>>()
    val photos: LiveData<MutableList<Photo>> get() = _photos

    fun loadPhotos(){
        viewModelScope.launch {
            _photos.value = getRemotePhotoGalleryUseCase.invoke().toMutableList()
        }
    }




}