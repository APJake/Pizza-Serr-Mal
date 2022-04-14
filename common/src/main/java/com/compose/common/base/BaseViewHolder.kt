package com.compose.common.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    private var _data: T? = null
    val data: T
        get() = _data!!

    open fun bind(item: T) {
        _data = item
    }
}