package com.example.shared

import android.app.Application

class DogGalleryApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}