package com.mysliukserhii.mynewcoursework.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mysliukserhii.mynewcoursework.diet.Diet
import com.mysliukserhii.mynewcoursework.diet.DietDao
import com.mysliukserhii.mynewcoursework.dishes.Dishes
import com.mysliukserhii.mynewcoursework.dishes.DishesDao
import com.mysliukserhii.mynewcoursework.foodConstructer.Constructor
import com.mysliukserhii.mynewcoursework.foodConstructer.ConstructorDao
import com.mysliukserhii.mynewcoursework.user.User
import com.mysliukserhii.mynewcoursework.user.UserDao


@Database(
    version = 2,
    entities = [
        Diet::class,
        Dishes::class,
        Constructor::class,
        User::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun UserDao(): UserDao
    abstract fun DietDao(): DietDao
    abstract fun DishesDao(): DishesDao
    abstract fun ConstructorDao(): ConstructorDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "appstore_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}