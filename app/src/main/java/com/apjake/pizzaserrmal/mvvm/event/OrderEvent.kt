package com.apjake.pizzaserrmal.mvvm.event

sealed class OrderEvent {
    data class Error(val message: String): OrderEvent()
}