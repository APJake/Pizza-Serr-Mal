package com.apjake.pizzaserrmal.network.datasource

import PizzaApi
import com.apjake.pizzaserrmal.appdata.PizzaNetworkDataSource
import com.apjake.pizzaserrmal.domain.models.PizzaVO
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class PizzaNetworkDataSourceImpl @Inject constructor(
    val pizzaApi: PizzaApi
) : PizzaNetworkDataSource {
    override fun getPizzaList(): Observable<List<PizzaVO>> {
        TODO("Not yet implemented")
    }


}