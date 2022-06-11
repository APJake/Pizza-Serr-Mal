package com.apjake.pizzaserrmal.network.response

data class PizzaResponse(
    val id: String?,
    val name: String?,
    val veg: Boolean?,
    val price: Int?,
    val description: String?,
    val img: String?
)
