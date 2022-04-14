package com.apjake.pizzaserrmal.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apjake.pizzaserrmal.appdata.PizzaNetworkDataSource

import com.apjake.pizzaserrmal.mvvm.event.PizzaListEvent
import com.apjake.pizzaserrmal.common.base.BaseViewModel
import com.apjake.pizzaserrmal.mvvm.state.PizzaState
import com.apjake.pizzaserrmal.network.datasource.PizzaNetworkDataSourceImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class PizzaViewModel @Inject constructor(
    private val pizzaNetworkDataSource: PizzaNetworkDataSourceImpl
) : BaseViewModel<PizzaListEvent>() {

    private val _pizzaListState = MutableLiveData<PizzaState>()
    val pizzaLisState: LiveData<PizzaState> = _pizzaListState

    fun getPizzaList() {
        pizzaNetworkDataSource.getPizzaList()
    }
}