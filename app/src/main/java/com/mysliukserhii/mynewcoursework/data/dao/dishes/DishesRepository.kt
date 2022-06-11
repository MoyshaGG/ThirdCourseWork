package com.mysliukserhii.mynewcoursework.data.dao.dishes

import androidx.lifecycle.LiveData
import com.mysliukserhii.mynewcoursework.data.AppDataBase
import com.mysliukserhii.mynewcoursework.data.dao.dishes.Dishes
import com.mysliukserhii.mynewcoursework.data.dao.dishes.DishesDao

class DishesRepository {

    private val db = AppDataBase.getInstance()
    private val constructorDao = db.ConstructorDao()
    private val dietDao = db.DietDao()
    private val dishesDao = db.DishesDao()
    private val userDao = db.UserDao()

    suspend fun getAllDishes(result: (List<Dishes>) -> Unit) {
        val dishesList = dishesDao.getAllDishes()
        result(dishesList)
    }

    suspend fun addDishes(dishes: Dishes){
        dishesDao.addDishes(dishes)
    }
}