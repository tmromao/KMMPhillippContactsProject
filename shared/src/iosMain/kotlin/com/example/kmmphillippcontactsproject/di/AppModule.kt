package com.example.kmmphillippcontactsproject.di

import android.content.Context
import com.example.kmmphillippcontactsproject.ContactDatabase
import com.example.kmmphillippcontactsproject.contacts.data.SqlDelightContactDataSource
import com.example.kmmphillippcontactsproject.contacts.domain.ContactDataSource
import com.example.kmmphillippcontactsproject.core.data.DatabaseDriverFactory

actual class AppModule {
    actual val contactDataSource: ContactDataSource by lazy {
        SqlDelightContactDataSource(
            db = ContactDatabase(
                driver = DatabaseDriverFactory().create()
            )
        )
    }
}