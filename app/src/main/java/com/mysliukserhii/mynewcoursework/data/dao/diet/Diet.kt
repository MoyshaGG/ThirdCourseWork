package com.mysliukserhii.mynewcoursework.data.dao.diet

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diets")
data class Diet(
    @PrimaryKey(autoGenerate = true)
    val diet_id: Long = 0 ,
    val dietName: String
)


