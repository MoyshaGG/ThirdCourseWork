package com.mysliukserhii.mynewcoursework.data.dao.foodConstructer

import androidx.room.*
import com.mysliukserhii.mynewcoursework.data.dao.diet.Diet
import com.mysliukserhii.mynewcoursework.data.dao.dishes.Dishes


@Entity(
    tableName = "constructor_food",
    primaryKeys = ["diet_id", "dish_id"],
    indices = [
        Index("dish_id")
    ],
    foreignKeys = [
        ForeignKey
            (
            entity = Diet::class,
            parentColumns = ["diet_id"],
            childColumns = ["diet_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),

        ForeignKey(
            entity = Dishes::class,
            parentColumns = ["dish_id"],
            childColumns = ["dish_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)


data class Constructor(
    @ColumnInfo(name = "diet_id")
    val diet_id: Int,
    @ColumnInfo(name = "dish_id")
    val dish_id: Int,
    @ColumnInfo
    val day: String,
    @ColumnInfo
    val time: Int,

    )

