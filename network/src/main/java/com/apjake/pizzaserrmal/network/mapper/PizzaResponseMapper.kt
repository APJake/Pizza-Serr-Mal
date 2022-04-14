package com.apjake.pizzaserrmal.network.mapper

import PizzaResponse
import com.apjake.pizzaserrmal.common.util.UniMapper
import com.apjake.pizzaserrmal.common.util.orFalse
import com.apjake.pizzaserrmal.domain.models.PizzaVO
import com.apjake.pizzaserrmal.network.response.Pizza
import javax.inject.Inject

class PizzaResponseMapper @Inject constructor() : UniMapper<List<PizzaResponse>?, List<PizzaVO>> {
    override fun map(data: List<PizzaResponse>?): List<PizzaVO> {
        return data?.map { pizza ->
            PizzaVO(
                id = pizza.id.toString(),
                name = pizza.name.orEmpty(),
                isVeg = pizza.veg.orFalse(),
                description = pizza.description.orEmpty(),
                image = pizza.img.orEmpty(),
                price = pizza.img.orEmpty(),
                isBookmark = false
            )
        }.orEmpty()
    }
}