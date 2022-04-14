package com.apjake.pizzaserrmal.network.mapper

import com.apjake.pizzaserrmal.domain.Pizza
import PizzaListResponse
import com.apjake.pizzaserrmal.common.util.UniMapper

class PizzaResponseMapper: UniMapper<PizzaListResponse,List<Pizza> > {
    override fun map(data: PizzaListResponse): List<Pizza> {
        return data;
    }
}