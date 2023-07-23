package com.example.kmmphillippcontactsproject.contacts.data

import com.example.kmmphillippcontactsproject.contacts.domain.Contact
import database.ContactEntity

fun ContactEntity.toContact(): Contact {
    return Contact(
        id = id,
        firstName = firstName,
        lastName = lastName,
        phoneNumber = phoneNumber,
        email = email,
        photoBytes = null // TODO: Get the image
    )
}