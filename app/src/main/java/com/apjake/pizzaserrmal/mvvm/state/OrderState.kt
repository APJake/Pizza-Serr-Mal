package com.apjake.pizzaserrmal.mvvm.state

import com.apjake.pizzaserrmal.mvvm.item.PizzaItem

sealed class OrderState {
    data class Loaded(val item: PizzaItem) : OrderState()
}
