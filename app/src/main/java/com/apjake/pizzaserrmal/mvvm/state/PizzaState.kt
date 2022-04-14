package com.apjake.pizzaserrmal.mvvm.state

import com.apjake.pizzaserrmal.domain.models.PizzaVO

sealed class PizzaState {
    data class Success(val item: List<PizzaVO>) : PizzaState()
}
