package com.apjake.pizzaserrmal.domain.models

data class PizzaVO(
    val id: String,
    val name: String,
    val isVeg: Boolean,
    val description: String,
    val image: String,
    val price: String,
    val isBookmark: Boolean
)
