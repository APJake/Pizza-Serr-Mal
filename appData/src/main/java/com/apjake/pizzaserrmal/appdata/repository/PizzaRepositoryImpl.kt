package com.apjake.pizzaserrmal.appdata.repository

import com.apjake.pizzaserrmal.appdata.PizzaNetworkDataSource
import com.apjake.pizzaserrmal.domain.models.PizzaVO
import com.apjake.pizzaserrmal.domain.models.repository.PizzaRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class PizzaRepositoryImpl @Inject constructor(private val pizzaNetworkDataSource: PizzaNetworkDataSource) :
    PizzaRepository {
    override fun getVegPizzaList(): Observable<List<PizzaVO>> {
        return pizzaNetworkDataSource.getPizzaList().map { pizzaList ->
            pizzaList.filter { pizza ->
                pizza.isVeg
            }
        }
    }

    override fun getUnVegPizzaList(): Observable<List<PizzaVO>> {
        return pizzaNetworkDataSource.getPizzaList().map { pizzaList ->
            pizzaList.filter { pizza ->
                !pizza.isVeg
            }
        }
    }

    override fun getPizzaDetail(pizzaId: String): Observable<PizzaVO> {
        return pizzaNetworkDataSource.getPizzaList().filter { pizzaList ->
            pizzaList.find { pizzaVO ->
                pizzaVO.id == pizzaId
            } != null
        }.map { list->
            list[0]
        }
    }
}