package com.mysliukserhii.mynewcoursework.user

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mysliukserhii.mynewcoursework.dishes.Dishes
import com.mysliukserhii.mynewcoursework.foodConstructer.Constructor
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)


    @Query("SELECT * FROM users")
    fun getAllUsersLiveData() : LiveData<List<User>>

    @Query("SELECT * FROM users")
    suspend fun getAllUsers() : List<User>
}