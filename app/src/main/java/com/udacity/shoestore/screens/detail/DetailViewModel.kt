package com.udacity.shoestore.screens.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class DetailViewModel : ViewModel() {
    private val _shoe = MutableLiveData<Shoe>()
    val shoe : MutableLiveData<Shoe>
        get() = _shoe


}