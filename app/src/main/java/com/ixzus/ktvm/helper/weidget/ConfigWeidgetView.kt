package com.ixzus.ktvm.helper.weidget

import android.view.ViewManager
import de.hdodenhof.circleimageview.CircleImageView
import org.jetbrains.anko.custom.ankoView

/**
 * Created by Administrator on 2018/3/6.
 */
inline fun ViewManager.circleImageView(theme: Int = 0, init: CircleImageView.() -> Unit): CircleImageView {
    return ankoView({ CircleImageView(it) }, theme = theme, init = init)
}
