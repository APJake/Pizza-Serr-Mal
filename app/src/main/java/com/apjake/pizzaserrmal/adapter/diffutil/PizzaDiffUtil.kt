package com.apjake.pizzaserrmal.adapter.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.apjake.pizzaserrmal.domain.models.PizzaVO
import com.apjake.pizzaserrmal.mvvm.item.PizzaUI

object PizzaDiffUtil : DiffUtil.ItemCallback<PizzaUI>() {
    override fun areItemsTheSame(oldItem: PizzaUI, newItem: PizzaUI): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: PizzaUI, newItem: PizzaUI): Boolean {
        return false
    }

}