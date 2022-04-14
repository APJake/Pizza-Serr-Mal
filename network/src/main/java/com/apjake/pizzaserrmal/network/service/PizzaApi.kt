package com.apjake.pizzaserrmal.network.service

import com.apjake.pizzaserrmal.network.response.PizzaResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface PizzaApi {
    @GET("pizzas")
    fun getAllPizza(): Observable<List<PizzaResponse>>
}