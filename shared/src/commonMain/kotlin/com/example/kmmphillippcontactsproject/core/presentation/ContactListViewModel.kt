package com.example.kmmphillippcontactsproject.core.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.kmmphillippcontactsproject.contacts.domain.Contact
import com.example.kmmphillippcontactsproject.contacts.presentation.components.ContactListEvent
import com.example.kmmphillippcontactsproject.contacts.presentation.components.ContactListState
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ContactListViewModel : ViewModel() {

    private val _state = MutableStateFlow(
        ContactListState(
            contacts = contacts
        )
    )
    val state = _state.asStateFlow()

    var newContact: Contact? by mutableStateOf(null)
        private set

    fun onEvent(event: ContactListEvent) {}
}

private val contacts = (1..30).map {
    Contact(
        id = it.toLong(),
        firstName = "First Name $it",
        lastName = "Last Name $it",
        email = "Email $it",
        phoneNumber = "123456789",
        photoBytes = null
    )
}