package com.mysliukserhii.mynewcoursework.ui.cobstructor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mysliukserhii.mynewcoursework.data.dao.dishes.Dishes
import com.mysliukserhii.mynewcoursework.data.dao.dishes.DishesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConstrutorViewModel : ViewModel() {

    private val repo = DishesRepository()
    private var _contentListLiveData = MutableLiveData<List<Dishes>>()
    var contentListLiveData: LiveData<List<Dishes>> = _contentListLiveData

    init {
        viewModelScope.launch {
            getDishes()
        }
    }

    private suspend fun getDishes() {
        repo.getAllDishes {
            _contentListLiveData.value = it
        }
    }

    fun addDishes(dishes: Dishes) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addDishes(dishes)
        }
    }
}