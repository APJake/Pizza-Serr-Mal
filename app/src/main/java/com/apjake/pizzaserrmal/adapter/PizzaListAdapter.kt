package com.apjake.pizzaserrmal.adapter

import android.content.Context
import android.view.ViewGroup
import com.apjake.pizzaserrmal.adapter.diffutil.PizzaDiffUtil
import com.apjake.pizzaserrmal.databinding.ItemViewPizzaBinding
import com.apjake.pizzaserrmal.views.holders.PizzaViewHolder
import com.compose.common.base.BaseListAdapter
import com.compose.domain.models.PizzaVO

class PizzaListAdapter(c: Context) : BaseListAdapter<PizzaVO, PizzaViewHolder>(c, PizzaDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val binding = ItemViewPizzaBinding.inflate(inflater, parent, false)
        return PizzaViewHolder(binding)
    }
}