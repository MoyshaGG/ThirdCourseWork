package com.mysliukserhii.mynewcoursework.dishes

import androidx.lifecycle.LiveData

class DishesRepository(private val dishesDao: DishesDao) {
    val readAllData: LiveData<List<Dishes>> = dishesDao.readAllData()
    suspend fun addDishes(dishes: Dishes){
        dishesDao.addDishes(dishes)
    }
}