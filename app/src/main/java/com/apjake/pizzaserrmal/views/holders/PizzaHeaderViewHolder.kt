package com.apjake.pizzaserrmal.views.holders

import com.apjake.pizzaserrmal.common.base.BaseViewHolder
import com.apjake.pizzaserrmal.databinding.ItemViewNonVegTitleBinding
import com.apjake.pizzaserrmal.mvvm.item.PizzaUI

class PizzaHeaderViewHolder(val binding: ItemViewNonVegTitleBinding) : BaseViewHolder<PizzaUI>(
    binding.root
) {
    override fun bind(item: PizzaUI) {
        super.bind(item)
        if (item is PizzaUI.Header)
            binding.tvTitle.text = item.item
    }
}