package com.apjake.pizzaserrmal.common.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.compose.common.R
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

fun String.prefixDollar(): String = "$ $this"

fun ImageView.show(imageUrl: String) {
    Glide.with(this)

        .load(imageUrl)
        .apply(
            RequestOptions.fitCenterTransform()
                .error(R.drawable.abc_vector_test)
        )
        .into(this)
}

fun Boolean?.orFalse(): Boolean = this ?: false

fun Disposable.addDisposable(disposable: CompositeDisposable) {
    disposable.add(this)
}

fun Boolean.toVegString(): String = if(this) "Vegetarian" else "Non-Vegetarian"