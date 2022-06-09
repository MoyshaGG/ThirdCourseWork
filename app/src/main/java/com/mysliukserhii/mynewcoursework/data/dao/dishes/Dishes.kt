package com.mysliukserhii.mynewcoursework.data.dao.dishes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dishes")
data class Dishes(
    @PrimaryKey(autoGenerate = true)
    val dish_id:Int,
    @ColumnInfo
    val name:String,
    @ColumnInfo
    val cal:String)


