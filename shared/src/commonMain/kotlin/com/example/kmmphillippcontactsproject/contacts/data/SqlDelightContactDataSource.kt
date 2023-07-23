package com.example.kmmphillippcontactsproject.contacts.data

import com.example.kmmphillippcontactsproject.ContactDatabase
import com.example.kmmphillippcontactsproject.contacts.domain.Contact
import com.example.kmmphillippcontactsproject.contacts.domain.ContactDataSource
import kotlinx.coroutines.flow.Flow

class SqlDelightContactDataSource (
    db: ContactDatabase
    ):ContactDataSource{
    override fun getContacts(): Flow<List<Contact>> {
        TODO("Not yet implemented")
    }

    override fun getRecentContacts(amount: Int): Flow<List<Contact>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertContact(contact: Contact) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteContact(id: Long) {
        TODO("Not yet implemented")
    }

}