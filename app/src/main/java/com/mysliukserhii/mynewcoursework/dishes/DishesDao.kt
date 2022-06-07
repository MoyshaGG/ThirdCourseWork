package com.mysliukserhii.mynewcoursework.dishes

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mysliukserhii.mynewcoursework.foodConstructer.Constructor
@Dao
interface DishesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dishes: Dishes)

    @Delete
    suspend fun delete(dishes: Dishes)

    @Update
    suspend fun update(dishes: Dishes)

    @Query("SELECT * FROM dishes")
    fun getAllDishesLiveData() : LiveData<List<Dishes>>

    @Query("SELECT * FROM dishes")
    suspend fun getAllDishes() : List<Dishes>

    @Query("SELECT COUNT(*) FROM dishes")
    suspend fun count() : Int
}