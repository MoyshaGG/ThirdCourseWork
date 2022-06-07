package com.mysliukserhii.mynewcoursework.foodConstructer

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.mysliukserhii.mynewcoursework.diet.Diet
import com.mysliukserhii.mynewcoursework.dishes.Dishes
import com.mysliukserhii.mynewcoursework.user.User


data class DietWithDishes(
    @Embedded val diet: Diet,
    @Relation(
        parentColumn = "diet_id",
        entityColumn = "dish_id",
        associateBy = Junction(Constructor::class)
    )
    val dishes: List<Dishes>
)