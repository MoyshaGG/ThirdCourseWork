package com.mysliukserhii.mynewcoursework.ui.add_dish

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mysliukserhii.mynewcoursework.data.dao.dishes.Dishes
import com.mysliukserhii.mynewcoursework.data.dao.dishes.DishesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddDishViewModel : ViewModel() {
    private val repo = DishesRepository()

    fun addDishes(dishes: Dishes)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addDishes(dishes)
        }
    }
}