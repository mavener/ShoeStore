package com.udacity.shoestore.screens.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.Event

class WelcomeViewModel : ViewModel() {
    private val _eventNext = MutableLiveData<Event<Boolean>>()
    val eventNext: LiveData<Event<Boolean>>
        get() = _eventNext

    fun onNext() {
        _eventNext.value = Event(true)
    }

}