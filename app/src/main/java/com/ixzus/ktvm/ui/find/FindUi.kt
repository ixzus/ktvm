package com.ixzus.ktvm.ui.find

import com.ixzus.ktvm.ext.replaceFragment
import com.ixzus.ktvm.ui.find.inputitem.InputFragment
import com.ixzus.ktvm.ui.main.Main
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by Administrator on 2018/3/7.
 */
class FindUi : AnkoComponent<FindFragment> {
    override fun createView(ui: AnkoContext<FindFragment>) = with(ui) {
        frameLayout {
            button("设置item") {
                onClick {
                    owner.replaceFragment(Main.Ids.main_frame, InputFragment.newInstance("", ""))

                }
            }.lparams(width = wrapContent, height = wrapContent)
        }
    }
}