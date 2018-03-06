package com.ixzus.ktvm.ext

import android.content.Context
import android.content.res.Resources
import android.support.annotation.AttrRes
import android.support.annotation.ColorInt
import android.util.TypedValue

/**
 * Created by Administrator on 2018/3/6.
 */

fun Context.getResourceId(@AttrRes attribute: Int): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute(attribute, typedValue, true)
    return typedValue.resourceId
}

@ColorInt
fun Resources.Theme.getColor(@AttrRes attribute: Int): Int {
    val typedValue = TypedValue()
    if (resolveAttribute(attribute, typedValue, true)) {
        return typedValue.data
    }

    return 0
}