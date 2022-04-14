package com.apjake.pizzaserrmal.network.mapper

import PizzaListResponse
import com.apjake.pizzaserrmal.common.util.UniMapper
import com.apjake.pizzaserrmal.domain.models.PizzaVO
import com.apjake.pizzaserrmal.network.response.Pizza

class PizzaResponseMapper: UniMapper<PizzaListResponse,List<PizzaVO> > {
    override fun map(data: PizzaListResponse): List<PizzaVO> {
        return data.map { pizza -> PizzaVO(id = pizza.id.toString(), name = pizza.name, isVeg = pizza.veg,
            description = pizza.description, image = pizza.img, price = pizza.img, isBookmark = false)
        }
    }
}
