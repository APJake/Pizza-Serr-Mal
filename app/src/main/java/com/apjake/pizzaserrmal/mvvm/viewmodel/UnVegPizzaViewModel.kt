package com.apjake.pizzaserrmal.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apjake.pizzaserrmal.common.base.BaseViewHolder
import com.apjake.pizzaserrmal.common.base.BaseViewModel
import com.apjake.pizzaserrmal.domain.models.usecase.GetUnVegPizzaListUseCase
import com.apjake.pizzaserrmal.mvvm.event.PizzaListEvent
import com.apjake.pizzaserrmal.mvvm.mapper.PizzaItemMapper
import com.apjake.pizzaserrmal.mvvm.state.PizzaState
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class UnVegPizzaViewModel @Inject constructor(
    private val getUnVegPizzaListUseCase: GetUnVegPizzaListUseCase,
    private val pizzaItemMapper: PizzaItemMapper

) : BaseViewModel<PizzaListEvent>() {

    private val _pizzaListState = MutableLiveData<PizzaState>()
    val pizzaLisState: LiveData<PizzaState> = _pizzaListState

    fun getPizzaList() {
        getUnVegPizzaListUseCase()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _pizzaListState.value =
                    PizzaState.Success(pizzaItemMapper.map(it))
            }, {
                emit(PizzaListEvent.Error(it.message.orEmpty()))
            })
            .addTo(dispose)
    }
}