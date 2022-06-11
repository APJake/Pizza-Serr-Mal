package com.apjake.pizzaserrmal.domain.models.repository

import com.apjake.pizzaserrmal.domain.models.PizzaVO
import io.reactivex.rxjava3.core.Observable

interface PizzaRepository {
    fun getVegPizzaList(): Observable<List<PizzaVO>>
    fun getUnVegPizzaList(): Observable<List<PizzaVO>>
    fun getPizzaDetail(pizzaId: String): Observable<PizzaVO>
}