package com.example.kmmphillippcontactsproject.contacts.data

import com.example.kmmphillippcontactsproject.ContactDatabase
import com.example.kmmphillippcontactsproject.contacts.domain.Contact
import com.example.kmmphillippcontactsproject.contacts.domain.ContactDataSource
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock

class SqlDelightContactDataSource(
    db: ContactDatabase,
) : ContactDataSource {

    private val queries = db.contactQueries

    override fun getContacts(): Flow<List<Contact>> {
        return queries
            .getContacts()
            .asFlow()
            .mapToList()
            .map { contactEntities ->
                contactEntities.map { contactEntity ->
                    contactEntity.toContact()
                }
            }
    }


    override fun getRecentContacts(amount: Int): Flow<List<Contact>> {
        return queries
            .getRecentContacts(amount.toLong())
            .asFlow()
            .mapToList()
            .map { contactEntities ->
                contactEntities.map { contactEntity ->
                    contactEntity.toContact()
                }
            }
    }

    override suspend fun insertContact(contact: Contact) {
        queries.insertContactEntity(
            id = contact.id,
            firstName = contact.firstName,
            lastName = contact.lastName,
            phoneNumber = contact.phoneNumber,
            email = contact.email,
            createdAt = Clock.System.now().toEpochMilliseconds(),
            imagePath = null
        )
    }

    override suspend fun deleteContact(id: Long) {
        queries.deleteContact(id)
    }

}