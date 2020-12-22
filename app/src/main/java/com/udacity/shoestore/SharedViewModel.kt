package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

enum class SavedState {
    DEFAULT, SUCCESS, ERROR
}

class SharedViewModel : ViewModel() {



    val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    val _saveState = MutableLiveData<SavedState>(SavedState.DEFAULT)
    val saveState : LiveData<SavedState>
        get() = _saveState


    init {
        _shoeList.value = Shoe.INITIAL_DATA
    }


    fun addShoe(shoe: Shoe) {
        if (shoe.name.isEmpty() || shoe.size <= 0 || shoe.company.isEmpty() || shoe.description.isEmpty())
        {
            _saveState.value = SavedState.ERROR
        } else {
            _shoeList.value?.add(shoe)
            _saveState.value = SavedState.SUCCESS
        }
    }

    fun resetSavedState() {
        _saveState.value = SavedState.DEFAULT
    }

}