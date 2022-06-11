package com.apjake.pizzaserrmal.adapter

import android.content.Context
import android.view.ViewGroup
import com.apjake.pizzaserrmal.adapter.diffutil.PizzaDiffUtil
import com.apjake.pizzaserrmal.databinding.ItemViewPizzaBinding
import com.apjake.pizzaserrmal.views.holders.PizzaViewHolder
import com.apjake.pizzaserrmal.common.base.BaseListAdapter
import com.apjake.pizzaserrmal.common.base.BaseViewHolder
import com.apjake.pizzaserrmal.databinding.ItemViewNonVegTitleBinding
import com.apjake.pizzaserrmal.domain.models.PizzaVO
import com.apjake.pizzaserrmal.mvvm.item.PizzaUI
import com.apjake.pizzaserrmal.views.holders.PizzaHeaderViewHolder

class PizzaListAdapter(c: Context) :
    BaseListAdapter<PizzaUI, BaseViewHolder<PizzaUI>>(c, PizzaDiffUtil) {

    val HEADER = 1
    val ITEM = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<PizzaUI> {
        if (viewType == HEADER) {
            val binding = ItemViewNonVegTitleBinding.inflate(inflater, parent, false)
            return PizzaHeaderViewHolder(binding)
        }
        val binding = ItemViewPizzaBinding.inflate(inflater, parent, false)
        return PizzaViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item is PizzaUI.Header)
            HEADER
        else ITEM
    }
}