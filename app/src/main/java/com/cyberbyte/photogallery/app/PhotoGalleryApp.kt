package com.cyberbyte.photogallery.app

import android.app.Application
import com.cyberbyte.photogallery.service.PhotoGalleryApiService
import com.cyberbyte.photogallery.usecase.GetRemotePhotoGalleryUseCase
import okhttp3.OkHttpClient
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhotoGalleryApp : Application(), DIAware
{
    override val di by DI.lazy{
        import(androidXModule(this@PhotoGalleryApp))

        //Retrofit
        bind<Retrofit>() with singleton {
            Retrofit.Builder()
                .baseUrl("https://api.pexels.com/v1/")
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        // PhotoGalleryService
        bind<PhotoGalleryApiService>() with singleton {
            instance<Retrofit>().create(PhotoGalleryApiService::class.java)
        }

        // UseCases
        bind<GetRemotePhotoGalleryUseCase>() with singleton {
            GetRemotePhotoGalleryUseCase(instance())
        }
    }

}