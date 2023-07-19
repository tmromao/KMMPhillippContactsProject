package com.example.kmmphillippcontactsproject

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform