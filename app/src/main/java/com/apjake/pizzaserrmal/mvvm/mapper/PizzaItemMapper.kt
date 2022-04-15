package com.apjake.pizzaserrmal.mvvm.mapper

import com.apjake.pizzaserrmal.common.util.UniMapper
import com.apjake.pizzaserrmal.domain.models.PizzaPrizeRange
import com.apjake.pizzaserrmal.domain.models.PizzaVO
import com.apjake.pizzaserrmal.mvvm.item.PizzaItem
import com.apjake.pizzaserrmal.mvvm.item.PizzaUI

class PizzaItemMapper: UniMapper<List<PizzaVO>, PizzaUI> {
    override fun map(data: List<PizzaVO>): PizzaUI {
        val cheapList = data.filter { it.range==PizzaPrizeRange.CHEAP }
        val mediumList = data.filter { it.range==PizzaPrizeRange.MEDIUM }
        val expensiveList = data.filter { it.range==PizzaPrizeRange.EXPENSIVE }
        return PizzaUI(
            cheapItem = PizzaItem(title = "Cheap", pizzaList = cheapList),
            mediumItem = PizzaItem(title = "Medium", pizzaList = mediumList),
            expensiveItem = PizzaItem(title = "Expensive", pizzaList = expensiveList)
        )
    }
}