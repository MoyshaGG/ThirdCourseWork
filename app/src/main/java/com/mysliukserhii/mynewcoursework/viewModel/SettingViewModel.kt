package com.mysliukserhii.mynewcoursework.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.mysliukserhii.mynewcoursework.dishes.Dishes
import com.mysliukserhii.mynewcoursework.dishes.DishesRepository
import com.mysliukserhii.mynewcoursework.room.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SettingViewModel(application: Application) : AndroidViewModel(application) {
     val readAllData: LiveData<List<Dishes>>
     private val repository: DishesRepository

    init {
        val dishesDao = AppDatabase.getInstance(application).DishesDao()
        repository = DishesRepository(dishesDao)
        readAllData = repository.readAllData
    }
    fun addDishes(dishes: Dishes)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDishes(dishes)
        }
    }
}