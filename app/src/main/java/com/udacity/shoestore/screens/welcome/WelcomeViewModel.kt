package com.udacity.shoestore.screens.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {
    private val _eventNext = MutableLiveData<Boolean>(false)
    val eventNext: LiveData<Boolean>
        get() = _eventNext



    fun onNext() {
        _eventNext.value = true
    }

    fun onNextDone() {
        _eventNext.value = false
    }
}