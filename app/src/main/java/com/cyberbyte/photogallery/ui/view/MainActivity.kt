package com.cyberbyte.photogallery.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.cyberbyte.photogallery.databinding.ActivityMainBinding
import com.cyberbyte.photogallery.model.Photo
import androidx.fragment.app.Fragment
import com.cyberbyte.photogallery.ui.adapter.PhotoAdapter
import com.cyberbyte.photogallery.ui.adapter.PhotoListener
import com.cyberbyte.photogallery.ui.viewmodel.MainViewModel
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import org.kodein.di.instance

class MainActivity : AppCompatActivity(), DIAware, PhotoListener {

    override val di by closestDI()

    private lateinit var binding: ActivityMainBinding
    private lateinit var photoAdapter: PhotoAdapter

    private val viewModel: MainViewModel by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        photoAdapter = PhotoAdapter(emptyList(), this)

        binding.recyclerViewMovie.layoutManager = GridLayoutManager(this, 3)
        binding.recyclerViewMovie.adapter = photoAdapter

        viewModel.photos.observe(this){ photos ->
            photoAdapter.updatePhotos(photos)
        }
        viewModel.loadPhotos()

        setContentView(binding.root)

    }

    override fun onPhotoClicked(photo: Photo) {
        TODO("Not yet implemented")
    }
}