package com.example.studykmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform