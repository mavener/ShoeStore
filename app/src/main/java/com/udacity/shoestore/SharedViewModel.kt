package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe



class SharedViewModel : ViewModel() {



    val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    val _saveState = MutableLiveData<Int>(0)
    val saveState : LiveData<Int>
        get() = _saveState


    init {
        _shoeList.value = Shoe.INITIAL_DATA
    }


    fun addShoe(shoe: Shoe) {
        if (shoe.name.isEmpty() || shoe.size <= 0.0 || shoe.company.isEmpty() || shoe.description.isEmpty())
        {
            _saveState.value = -1
        } else {
            val shoeList = _shoeList.value as MutableList<Shoe>
            shoeList.add(shoe)
            _shoeList.value = shoeList

            _saveState.value = 1
        }
    }

    fun resetSavedState() {
        _saveState.value = 0
    }

}