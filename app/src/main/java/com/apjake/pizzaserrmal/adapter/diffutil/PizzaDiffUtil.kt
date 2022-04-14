package com.apjake.pizzaserrmal.adapter.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.compose.domain.models.PizzaVO

object PizzaDiffUtil : DiffUtil.ItemCallback<PizzaVO>() {
    override fun areItemsTheSame(oldItem: PizzaVO, newItem: PizzaVO): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PizzaVO, newItem: PizzaVO): Boolean {
        return oldItem == newItem
    }
}