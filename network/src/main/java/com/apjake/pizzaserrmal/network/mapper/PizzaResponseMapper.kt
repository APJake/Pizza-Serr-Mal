package com.apjake.pizzaserrmal.network.mapper

import PizzaListResponse
import com.apjake.pizzaserrmal.common.util.UniMapper
import com.apjake.pizzaserrmal.network.response.Pizza

class PizzaResponseMapper: UniMapper<PizzaListResponse,List<Pizza> > {
    override fun map(data: PizzaListResponse): List<Pizza> {
        return data;
    }
}