package com.apjake.pizzaserrmal.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.apjake.pizzaserrmal.common.util.SingleLiveEvent
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseViewModel<E> : ViewModel() {
    private val _event = SingleLiveEvent<E>()
    protected val dispose = CompositeDisposable()
    val event: LiveData<E> = _event

    fun emit(event: E) {
        _event.value = event
    }

    override fun onCleared() {
        super.onCleared()
        dispose.clear()
    }
}