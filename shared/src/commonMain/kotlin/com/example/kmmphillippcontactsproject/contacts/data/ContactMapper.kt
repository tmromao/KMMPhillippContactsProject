package com.example.kmmphillippcontactsproject.contacts.data

import com.example.kmmphillippcontactsproject.contacts.domain.Contact
import com.example.kmmphillippcontactsproject.core.data.ImageStorage
import database.ContactEntity

suspend fun ContactEntity.toContact(imageStorage: ImageStorage): Contact {
    return Contact(
        id = id,
        firstName = firstName,
        lastName = lastName,
        phoneNumber = phoneNumber,
        email = email,
        photoBytes = imagePath?.let { imageStorage.getImage(it) }
    )
}