package com.cyberbyte.photogallery.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.cyberbyte.photogallery.databinding.ActivityMainBinding
import com.cyberbyte.photogallery.model.Photo
import com.cyberbyte.photogallery.ui.adapter.PhotoAdapter
import com.cyberbyte.photogallery.ui.adapter.PhotoListener
import com.cyberbyte.photogallery.ui.viewmodel.MainViewModel
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import org.kodein.di.instance

// Application's Main activity
class MainActivity : AppCompatActivity(), DIAware, PhotoListener {

    // Dependency Injection getting
    override val di by closestDI()
    // ViewBinding variable
    private lateinit var binding: ActivityMainBinding
    // Photo Item List Adapter
    private lateinit var photoAdapter: PhotoAdapter
    // ViewModel for Main Activity
    private val viewModel: MainViewModel by instance()

    // Handle create event
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

    // Handle Photo Item click by PhotoListener interface
    override fun onPhotoClicked(photo: Photo) {

    }
}