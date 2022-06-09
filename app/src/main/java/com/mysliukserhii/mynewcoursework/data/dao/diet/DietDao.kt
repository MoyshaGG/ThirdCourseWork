package com.mysliukserhii.mynewcoursework.diet

import androidx.room.*
import com.mysliukserhii.mynewcoursework.data.dao.diet.Diet

@Dao
interface DietDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(diet: Diet)

    @Delete
    suspend fun delete(diet: Diet)

    @Update
    suspend fun update(diet: Diet)

}