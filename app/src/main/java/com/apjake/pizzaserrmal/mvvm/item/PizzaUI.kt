package com.apjake.pizzaserrmal.mvvm.item


sealed class PizzaUI {
    data class Header (val item : String) : PizzaUI()
    data class Pizza (val item : PizzaItem) : PizzaUI()
}