package com.apjake.pizzaserrmal.common.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment<VM : BaseViewModel<E>, E> : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injectViewModel().event.observe(viewLifecycleOwner, ::bind)
    }

    abstract fun injectViewModel(): VM

    abstract fun bind(event: E)

}