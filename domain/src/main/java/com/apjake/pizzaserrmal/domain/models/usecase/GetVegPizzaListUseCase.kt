package com.apjake.pizzaserrmal.domain.models.usecase

import com.apjake.pizzaserrmal.domain.models.PizzaVO
import com.apjake.pizzaserrmal.domain.models.repository.PizzaRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GetVegPizzaListUseCase @Inject constructor(
    private val pizzaRepository: PizzaRepository
) {

    operator fun invoke(): Observable<List<PizzaVO>> {
        return pizzaRepository.getVegPizzaList().subscribeOn(Schedulers.io())
    }
}