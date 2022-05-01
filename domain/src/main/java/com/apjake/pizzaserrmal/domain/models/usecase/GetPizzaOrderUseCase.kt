package com.apjake.pizzaserrmal.domain.models.usecase

import com.apjake.pizzaserrmal.domain.models.PizzaVO
import com.apjake.pizzaserrmal.domain.models.repository.PizzaRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GetPizzaOrderUseCase @Inject constructor(
    private val pizzaRepository: PizzaRepository
) {
    operator fun invoke(pizzaId: String): Observable<PizzaVO>{
        return pizzaRepository.getPizzaDetail(pizzaId)
    }
}