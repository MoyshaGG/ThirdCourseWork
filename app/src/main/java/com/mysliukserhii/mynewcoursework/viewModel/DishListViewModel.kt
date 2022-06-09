package com.mysliukserhii.mynewcoursework.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mysliukserhii.mynewcoursework.dishes.Dishes
import com.mysliukserhii.mynewcoursework.dishes.DishesData
import com.mysliukserhii.mynewcoursework.room.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DishListViewModel (application: Application) : AndroidViewModel(application) {
     val dishesData: DishesData = DishesData()
     val _dishesLiveData = MutableLiveData<List<Dishes>>()
    val dishesLiveData: LiveData<List<Dishes>> = _dishesLiveData
     val dishesDataBase = AppDatabase.getInstance(application).DishesDao()
    val dishes = dishesDataBase.getAllDishesLiveData()


    init {
        viewModelScope.launch {
            insertDishesToDataBase()
        }
        viewModelScope.launch(Dispatchers.Main) {
            loadDishesData()
        }
    }

    private suspend fun loadDishesData() {
        _dishesLiveData.value = dishesDataBase.getAllDishes()
    }

    private suspend fun insertDishesToDataBase() {
        if (dishesDataBase.count() == 0) {
            for (dishes in dishesData.dishList)
                dishesDataBase.addDishes(dishes)
        }
    }
}