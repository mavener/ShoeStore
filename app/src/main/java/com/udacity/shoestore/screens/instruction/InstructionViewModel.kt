package com.udacity.shoestore.screens.instruction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.Event

class InstructionViewModel : ViewModel() {
    private val _eventNext = MutableLiveData<Event<Boolean>>()
    val eventNext: LiveData<Event<Boolean>>
        get() = _eventNext

    fun onNext() {
        _eventNext.value = Event(true)
    }

}