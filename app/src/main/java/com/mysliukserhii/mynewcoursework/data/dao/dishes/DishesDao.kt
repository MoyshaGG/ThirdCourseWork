package com.mysliukserhii.mynewcoursework.data.dao.dishes

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mysliukserhii.mynewcoursework.data.dao.dishes.Dishes

@Dao
interface DishesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDishes(dishes: Dishes)

    @Query("SELECT * FROM dishes ORDER BY dish_id ASC")
    fun readAllData():LiveData<List<Dishes>>

    @Delete
    suspend fun delete(dishes: Dishes)

    @Update
    suspend fun update(dishes: Dishes)

    //@Query("SELECT * FROM dishes")
  //  fun getAllDishesLiveData() : LiveData<List<Dishes>>

    @Query("SELECT * FROM dishes")
    suspend fun getAllDishes() : List<Dishes>

    @Query("SELECT COUNT(*) FROM dishes")
    suspend fun count() : Int
}