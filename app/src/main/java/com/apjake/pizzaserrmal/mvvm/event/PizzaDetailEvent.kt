package com.apjake.pizzaserrmal.mvvm.event

sealed class PizzaDetailEvent {
    data class Error(val message: String) : PizzaDetailEvent()
}
