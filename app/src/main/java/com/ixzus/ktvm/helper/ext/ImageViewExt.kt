package com.ixzus.ktvm.helper.ext

import android.widget.ImageView
import com.ixzus.ktvm.GlideApp
import com.ixzus.ktvm.R

/**
 * Created by Administrator on 2018/3/1.
 */

fun ImageView.loadImgFromUrl(url: String) {
    GlideApp.with(context)
            .load(url)
            .placeholder(R.mipmap.ic_launcher)
            .fitCenter()
            .into(this)
}