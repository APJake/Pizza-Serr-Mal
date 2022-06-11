package com.apjake.pizzaserrmal.views.holders

import com.apjake.pizzaserrmal.databinding.ItemViewPizzaBinding
import com.apjake.pizzaserrmal.common.base.BaseViewHolder
import com.apjake.pizzaserrmal.common.util.prefixDollar
import com.apjake.pizzaserrmal.common.util.show
import com.apjake.pizzaserrmal.domain.models.PizzaVO
import com.apjake.pizzaserrmal.mvvm.item.PizzaUI

class PizzaViewHolder(private val binding: ItemViewPizzaBinding) :
    BaseViewHolder<PizzaUI>(binding.root) {

    override fun bind(item: PizzaUI) {
        super.bind(item)
        if (item is PizzaUI.Pizza) {
            with(binding) {
                ivPizza.show(item.item.pizza.image)
                tvPrice.text = item.item.pizza.price.prefixDollar()
                tvPizzaName.text = item.item.pizza.name
                tvDesc.text = item.item.pizza.description
            }
        }

    }
}