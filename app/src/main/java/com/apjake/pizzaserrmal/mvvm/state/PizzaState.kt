package com.apjake.pizzaserrmal.mvvm.state

import com.apjake.pizzaserrmal.mvvm.item.PizzaItem
import com.apjake.pizzaserrmal.mvvm.item.PizzaUI

sealed class PizzaState {
    data class Success(val item: PizzaUI) : PizzaState()
}
