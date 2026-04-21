package com.example.doggallerykmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform