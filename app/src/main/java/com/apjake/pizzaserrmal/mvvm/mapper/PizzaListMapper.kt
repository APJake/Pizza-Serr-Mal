package com.apjake.pizzaserrmal.mvvm.mapper

import com.apjake.pizzaserrmal.common.util.UniMapper
import com.apjake.pizzaserrmal.common.util.toVegString
import com.apjake.pizzaserrmal.domain.models.PizzaPrizeRange
import com.apjake.pizzaserrmal.domain.models.PizzaVO
import com.apjake.pizzaserrmal.mvvm.item.PizzaItem
import com.apjake.pizzaserrmal.mvvm.item.PizzaUI
import javax.inject.Inject

class PizzaListMapper @Inject constructor(): UniMapper<List<PizzaVO>, List<PizzaUI>> {
    override fun map(data: List<PizzaVO>): List<PizzaUI> {
        val cheapList = data.filter { it.range == PizzaPrizeRange.CHEAP }
        val mediumList = data.filter { it.range == PizzaPrizeRange.MEDIUM }
        val expensiveList = data.filter { it.range == PizzaPrizeRange.EXPENSIVE }
        val pizzaUIs = mutableListOf<PizzaUI>()

        pizzaUIs.add(PizzaUI.Header("Cheap"))
        pizzaUIs.addAll(cheapList.map {
            PizzaUI.Pizza(PizzaItem("Cheap",it.isVeg.toVegString(), it))
        })

        pizzaUIs.add(PizzaUI.Header("Medium"))
        pizzaUIs.addAll(mediumList.map {
            PizzaUI.Pizza(PizzaItem("Medium",it.isVeg.toVegString(), it))
        })

        pizzaUIs.add(PizzaUI.Header("Expensive"))
        pizzaUIs.addAll(expensiveList.map {
            PizzaUI.Pizza(PizzaItem("Expensive",it.isVeg.toVegString(), it))
        })

        return pizzaUIs.toList()
    }
}