package com.apjake.pizzaserrmal.network.datasource

import com.apjake.pizzaserrmal.appdata.PizzaNetworkDataSource
import com.apjake.pizzaserrmal.domain.models.PizzaVO
import com.apjake.pizzaserrmal.network.mapper.PizzaResponseMapper
import com.apjake.pizzaserrmal.network.service.PizzaApi
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class PizzaNetworkDataSourceImpl @Inject constructor(
    private val pizzaApi: PizzaApi,
    private val pizzaResponseMapper: PizzaResponseMapper
) : PizzaNetworkDataSource {
    override fun getPizzaList(): Observable<List<PizzaVO>> {
        return pizzaApi.getAllPizza().map {
            pizzaResponseMapper.map(it)
        }
    }
}