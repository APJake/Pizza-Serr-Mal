package com.apjake.pizzaserrmal.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apjake.pizzaserrmal.common.base.BaseViewModel
import com.apjake.pizzaserrmal.domain.models.usecase.GetVegPizzaListUseCase
import com.apjake.pizzaserrmal.mvvm.event.PizzaListEvent
import com.apjake.pizzaserrmal.mvvm.state.PizzaState
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class VegViewModel @Inject constructor(
    private val getVegPizzaListUseCase: GetVegPizzaListUseCase
): BaseViewModel<PizzaListEvent>() {
    private val _pizzaListState = MutableLiveData<PizzaState>()
    val pizzaListState: LiveData<PizzaState> = _pizzaListState

    fun getPizzaList(){
        getVegPizzaListUseCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                       _pizzaListState.postValue(PizzaState.Success(it))
            },{
                emit(PizzaListEvent.Error(it.message.orEmpty()))
            })
    }
}