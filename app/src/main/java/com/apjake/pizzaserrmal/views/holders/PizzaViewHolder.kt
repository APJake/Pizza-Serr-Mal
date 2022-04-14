package com.apjake.pizzaserrmal.views.holders

import com.apjake.pizzaserrmal.databinding.ItemViewPizzaBinding
import com.compose.common.base.BaseViewHolder
import com.compose.common.util.prefixDollar
import com.compose.common.util.show
import com.compose.domain.models.PizzaVO

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