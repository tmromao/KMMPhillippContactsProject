package com.example.kmmphillippcontactsproject.di

import com.example.kmmphillippcontactsproject.contacts.domain.ContactDataSource

expect class AppModule {
    val contactDataSource: ContactDataSource
}