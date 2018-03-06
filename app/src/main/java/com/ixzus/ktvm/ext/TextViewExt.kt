package com.ixzus.ktvm.ext

import android.widget.TextView

/**
 * Created by Administrator on 2018/3/1.
 */
var TextView.textColor: Int
    get() = currentTextColor
    set(value) = setTextColor(value)