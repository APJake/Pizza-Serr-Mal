package com.apjake.pizzaserrmal.mvvm.viewmodel

import com.apjake.pizzaserrmal.mvvm.event.PizzaListEvent
import com.apjake.pizzaserrmal.mvvm.state.PizzaState
import com.compose.common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PizzaViewModel @Inject constructor() : BaseViewModel<PizzaListEvent>() {
}