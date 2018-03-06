package com.ixzus.ktvm.ui.main

import android.support.annotation.IdRes
import android.view.View
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.frameLayout

/**
 * Created by Administrator on 2018/3/6.
 */
class Main : AnkoComponent<MainActivity> {
    companion object Ids {
        @IdRes
        var main_frame: Int = View.generateViewId()
    }

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        frameLayout() {
            id = main_frame
        }
    }
}