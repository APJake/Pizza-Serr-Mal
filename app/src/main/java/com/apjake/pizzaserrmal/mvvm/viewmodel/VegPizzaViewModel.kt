package com.apjake.pizzaserrmal.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apjake.pizzaserrmal.mvvm.event.PizzaListEvent
import com.apjake.pizzaserrmal.common.base.BaseViewModel
import com.apjake.pizzaserrmal.domain.models.usecase.GetUnVegPizzaListUseCase
import com.apjake.pizzaserrmal.domain.models.usecase.GetVegPizzaListUseCase
import com.apjake.pizzaserrmal.mvvm.mapper.PizzaItemMapper
import com.apjake.pizzaserrmal.mvvm.state.PizzaState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

@HiltViewModel
class VegPizzaViewModel @Inject constructor(
    private val getVegPizzaListUseCase: GetVegPizzaListUseCase,

    private val pizzaItemMapper: PizzaItemMapper
) : BaseViewModel<PizzaListEvent>() {

    private val _pizzaListState = MutableLiveData<PizzaState>()
    val pizzaLisState: LiveData<PizzaState> = _pizzaListState

    fun getPizzaList() {
        getVegPizzaListUseCase()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ _pizzaListState.value = PizzaState.Success(pizzaItemMapper.map(it.sortedBy { it.price })) }, {
                emit(PizzaListEvent.Error(it.message.orEmpty()))
            })
            .addTo(dispose)
    }
}