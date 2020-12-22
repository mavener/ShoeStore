package com.udacity.shoestore.screens.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.Event

class ShoeListViewModel : ViewModel() {
    private val _eventAddShoe = MutableLiveData<Event<Boolean>>()
    val eventAddShoe: LiveData<Event<Boolean>>
        get() = _eventAddShoe

    fun onAddShoe() {
        _eventAddShoe.value = Event(true)
    }
}