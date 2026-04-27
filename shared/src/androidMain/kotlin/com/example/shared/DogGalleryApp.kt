package com.example.shared

import android.app.Application
import com.example.shared.di.initKoin

class DogGalleryApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}