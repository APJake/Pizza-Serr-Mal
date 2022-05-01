package com.apjake.pizzaserrmal.mvvm.mapper

import com.apjake.pizzaserrmal.common.util.UniMapper
import com.apjake.pizzaserrmal.common.util.toVegString
import com.apjake.pizzaserrmal.domain.models.PizzaVO
import com.apjake.pizzaserrmal.mvvm.item.PizzaItem
import javax.inject.Inject

class PizzaItemMapper @Inject constructor(): UniMapper<PizzaVO, PizzaItem> {
    override fun map(data: PizzaVO): PizzaItem {
        return PizzaItem(data.name, data.isVeg.toVegString(), data)
    }
}