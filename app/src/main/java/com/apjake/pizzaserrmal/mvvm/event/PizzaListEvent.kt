package com.apjake.pizzaserrmal.mvvm.event

sealed class PizzaListEvent {
    data class Error(val message: String) : PizzaListEvent()
}
