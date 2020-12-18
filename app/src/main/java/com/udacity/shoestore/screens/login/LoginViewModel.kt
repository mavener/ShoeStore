package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _eventLoginOrCreate = MutableLiveData<Boolean>(false)
    val eventLoginOrCreate: LiveData<Boolean>
        get() = _eventLoginOrCreate



    fun onLoginOrCreate() {
        _eventLoginOrCreate.value = true
    }

    fun onLoginOrCreateDone() {
        _eventLoginOrCreate.value = false
    }

}