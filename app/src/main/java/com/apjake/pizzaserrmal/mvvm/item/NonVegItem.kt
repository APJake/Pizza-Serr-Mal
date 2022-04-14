package com.apjake.pizzaserrmal.mvvm.item

import com.apjake.pizzaserrmal.domain.models.PizzaVO

sealed class NonVegItem {
    data class Header(val title: String) : NonVegItem()
    data class Pizza(val pizza: PizzaVO) : NonVegItem()
}
