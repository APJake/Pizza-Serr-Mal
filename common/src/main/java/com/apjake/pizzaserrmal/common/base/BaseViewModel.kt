package com.apjake.pizzaserrmal.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.apjake.pizzaserrmal.common.util.SingleLiveEvent

abstract class BaseViewModel<E> : ViewModel() {
    private val _event = SingleLiveEvent<E>()
    val event: LiveData<E> = _event

    fun emit(event: E) {
        _event.value = event
    }
}