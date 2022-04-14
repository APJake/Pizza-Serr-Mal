package com.apjake.pizzaserrmal.appdata

import com.apjake.pizzaserrmal.domain.models.PizzaVO
import io.reactivex.rxjava3.core.Observable

interface PizzaNetworkDataSource {
    fun getPizzaList(): Observable<List<PizzaVO>>
}