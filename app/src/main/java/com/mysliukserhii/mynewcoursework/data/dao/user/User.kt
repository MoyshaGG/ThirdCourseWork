package com.mysliukserhii.mynewcoursework.data.dao.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")

data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "user_weight")
    val weight: Int,
    @ColumnInfo(name = "user_height")
    val height: Int,
    @ColumnInfo(name = "user_age")
    val age: Int
)

