package com.example.kmmphillippcontactsproject.core.data

expect class ImageStorage {
    suspend fun saveImage(bytes: ByteArray): String
    suspend fun getImage(filename: String): ByteArray? // Nullable because may not exist
    suspend fun deleteImage(filename: String)
}