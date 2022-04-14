package com.apjake.pizzaserrmal.network.mapper

import com.apjake.pizzaserrmal.common.util.UniMapper
import com.apjake.pizzaserrmal.common.util.orFalse
import com.apjake.pizzaserrmal.domain.models.PizzaVO
import com.apjake.pizzaserrmal.network.response.PizzaResponse
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
                price = pizza.price.toString(),
                isBookmark = false
            )
        }.orEmpty()
    }
}