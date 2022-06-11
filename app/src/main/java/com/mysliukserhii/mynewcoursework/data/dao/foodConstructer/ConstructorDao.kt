package com.mysliukserhii.mynewcoursework.data.dao.foodConstructer

import androidx.room.*
import com.mysliukserhii.mynewcoursework.data.dao.dishes.Dishes

@Dao
interface ConstructorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(constructor: Constructor)

    @Delete
    suspend fun delete(constructor: Constructor)

    @Update
    suspend fun update(constructor: Constructor)

    @Query("SELECT * from constructor_food WHERE day = :day AND diet_id = :diet_id")
    suspend fun getConstructors(day: Int, diet_id : Int) : List<Constructor>?

    @Transaction
    @Query("SELECT * FROM diets")
    fun getDietsWithDishes(): List<DietWithDishes>

    @Transaction
    @Query("SELECT * FROM diets WHERE diet_id = :diet_id")
    fun getDietWithDishes(diet_id: Int): List<DietWithDishes>

//   @Query("SELECT  dish_id, dishes.name, dishes.cal FROM dishes LEFT JOIN " +
//           " constructor_food ON constructor_food.dish_id =  dishes.dish_id " +
//           "AND diet_id = :dietKey AND day = :day and time = :time")

    @Query("SELECT  dishes.dish_id, dishes.name, dishes.cal FROM constructor_food LEFT JOIN dishes ON constructor_food.dish_id =  dishes.dish_id \n" +
            "WHERE day = :day and time = :time")
       fun getUserWithApps( day: String, time: Int): Dishes

//    @Query("SELECT * " +
//            "FROM  " + "LEFT JOIN  " + "  ON  =  AND  = :accountId")
//    fun getBoxesAndSettings(accountId: Long): Flow<Map<BoxDbEntity, AccountBoxSettingDbEntity?>>
//

//    @Query(SQL)
//    suspend fun query(constructor: Constructor)

}