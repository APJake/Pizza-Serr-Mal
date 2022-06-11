package com.apjake.pizzaserrmal.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apjake.pizzaserrmal.common.base.BaseViewModel
import com.apjake.pizzaserrmal.domain.models.usecase.GetPizzaOrderUseCase
import com.apjake.pizzaserrmal.mvvm.event.OrderEvent
import com.apjake.pizzaserrmal.mvvm.mapper.PizzaItemMapper
import com.apjake.pizzaserrmal.mvvm.mapper.PizzaListMapper
import com.apjake.pizzaserrmal.mvvm.state.OrderState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val pizzaOrderUseCase: GetPizzaOrderUseCase,
    private val pizzaItemMapper: PizzaItemMapper
): BaseViewModel<OrderEvent>(){
    private val _pizzaItemState = MutableLiveData<OrderState>()
    val pizzaItemState: LiveData<OrderState> = _pizzaItemState

    fun getPizzaDetail(pizzaId: String) {
        pizzaOrderUseCase(pizzaId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _pizzaItemState.value = OrderState.Loaded(pizzaItemMapper.map(it))
                },
                {
                    emit(OrderEvent.Error(it.message.orEmpty()))
                }
            )
            .addTo(dispose)
    }
}