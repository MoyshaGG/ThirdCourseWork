package com.mysliukserhii.mynewcoursework.data.dao.user

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mysliukserhii.mynewcoursework.data.dao.user.User

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