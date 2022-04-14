package com.apjake.pizzaserrmal.common.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.compose.common.R

fun String.prefixDollar () : String = "$ $this"

fun ImageView.show(imageUrl: String) {
    Glide.with(this)

        .load(imageUrl)
        .apply(
            RequestOptions.fitCenterTransform()
                .error(R.drawable.abc_vector_test)
        )
        .into(this)
}