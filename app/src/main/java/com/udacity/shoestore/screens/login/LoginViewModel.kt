package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.Event

class LoginViewModel : ViewModel() {

    private val _eventLoginOrCreate = MutableLiveData<Event<Boolean>>()
    val eventLoginOrCreate: LiveData<Event<Boolean>>
        get() = _eventLoginOrCreate


    fun onLoginOrCreate() {
        _eventLoginOrCreate.value = Event(true)
    }
}