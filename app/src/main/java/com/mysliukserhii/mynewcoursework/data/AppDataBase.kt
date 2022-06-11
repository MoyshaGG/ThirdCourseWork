package com.mysliukserhii.mynewcoursework.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mysliukserhii.mynewcoursework.App
import com.mysliukserhii.mynewcoursework.data.dao.diet.Diet
import com.mysliukserhii.mynewcoursework.data.dao.dishes.Dishes
import com.mysliukserhii.mynewcoursework.diet.DietDao
import com.mysliukserhii.mynewcoursework.data.dao.dishes.DishesDao
import com.mysliukserhii.mynewcoursework.data.dao.foodConstructer.Constructor
import com.mysliukserhii.mynewcoursework.data.dao.foodConstructer.ConstructorDao
import com.mysliukserhii.mynewcoursework.data.dao.user.User
import com.mysliukserhii.mynewcoursework.data.dao.user.UserDao

@Database(
    entities = [Diet::class, Dishes::class, Constructor::class, User::class],
    version = 3
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun UserDao(): UserDao
    abstract fun DietDao(): DietDao
    abstract fun DishesDao(): DishesDao
    abstract fun ConstructorDao(): ConstructorDao

    companion object {

        private var instance: AppDataBase? = null

        fun getInstance(): AppDataBase {
            if (instance == null) {
                synchronized(AppDataBase::class.java) {
                    instance = Room.databaseBuilder(
                        App.context,
                        AppDataBase::class.java,
                        "App"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return instance!!
        }
    }
}