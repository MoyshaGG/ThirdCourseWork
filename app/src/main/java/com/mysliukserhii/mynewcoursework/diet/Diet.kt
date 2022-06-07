package com.mysliukserhii.mynewcoursework.diet

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diets")
data class Diet (
    @PrimaryKey(autoGenerate = true)
    val diet_id:Int,
    val dietName:String
)


