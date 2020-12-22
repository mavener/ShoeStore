package com.udacity.shoestore

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class SharedViewModel : ViewModel() {
    val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = Shoe.INITIAL_DATA
    }

    fun addShoe() {
//        _shoeList.value?.add(shoe)
        Timber.i("saved")
    }
}