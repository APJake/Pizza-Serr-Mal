package com.apjake.pizzaserrmal.views.holders

import com.apjake.pizzaserrmal.databinding.ItemViewPizzaBinding
import com.apjake.pizzaserrmal.common.base.BaseViewHolder
import com.apjake.pizzaserrmal.common.util.prefixDollar
import com.apjake.pizzaserrmal.common.util.show
import com.apjake.pizzaserrmal.domain.models.PizzaVO

class PizzaViewHolder(private val binding: ItemViewPizzaBinding) :
    BaseViewHolder<PizzaVO>(binding.root) {

    override fun bind(item: PizzaVO) {
        super.bind(item)
        binding.ivPizza.show(item.image)
        binding.tvPrice.text = item.price.prefixDollar()
        binding.tvPizzaName.text = item.name
        binding.tvDesc.text = item.description
    }
}