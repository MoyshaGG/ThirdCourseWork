package com.mysliukserhii.mynewcoursework.data.dao.foodConstructer

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.mysliukserhii.mynewcoursework.data.dao.diet.Diet
import com.mysliukserhii.mynewcoursework.data.dao.dishes.Dishes
import com.mysliukserhii.mynewcoursework.data.dao.foodConstructer.Constructor


data class DietWithDishes(
    @Embedded val diet: Diet,
    @Relation(
        parentColumn = "diet_id",
        entityColumn = "dish_id",
        associateBy = Junction(Constructor::class)
    )
    val dishes: List<Dishes>
)