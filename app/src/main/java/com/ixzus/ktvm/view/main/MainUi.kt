package com.ixzus.ktvm.view.main

import android.support.annotation.IdRes
import android.view.View
import com.ixzus.ktvm.R
import org.jetbrains.anko.*
import org.jetbrains.anko.design.bottomNavigationView

/**
 * Created by Administrator on 2018/3/5.
 */
class MainUi : AnkoComponent<MainFragment> {

    companion object Ids{
        @IdRes
        val id_content: Int = View.generateViewId()
        @IdRes
        val id_navigation: Int = View.generateViewId()
    }
    override fun createView(ui: AnkoContext<MainFragment>) = with(ui) {
        relativeLayout() {
            frameLayout {
                id = id_content
            }.lparams(width = matchParent, height = matchParent) {
                above(id_navigation)
            }

            owner.navigationView = bottomNavigationView {
                id = id_navigation
//                backgroundColor = android.R.attr.windowBackground
                inflateMenu(R.menu.menu_main)
            }.lparams(width = matchParent, height = wrapContent) {
                alignParentBottom()
            }

        }
    }
}