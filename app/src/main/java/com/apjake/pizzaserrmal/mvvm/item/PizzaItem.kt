package com.apjake.pizzaserrmal.mvvm.item

import com.apjake.pizzaserrmal.domain.models.PizzaVO

data class PizzaItem (
    val title: String,
    val pizzaList: List<PizzaVO>
)