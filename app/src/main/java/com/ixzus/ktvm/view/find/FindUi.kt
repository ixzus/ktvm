package com.ixzus.ktvm.view.find

import com.ixzus.ktvm.helper.ext.replaceFragment
import com.ixzus.ktvm.view.find.ble.FastBleFragment
import com.ixzus.ktvm.view.find.inputitem.InputFragment
import com.ixzus.ktvm.view.main.Main
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by Administrator on 2018/3/7.
 */
class FindUi : AnkoComponent<FindFragment> {
    override fun createView(ui: AnkoContext<FindFragment>) = with(ui) {
        verticalLayout() {
            button("设置item") {
                onClick {
                    owner.replaceFragment(Main.Ids.main_frame, InputFragment.newInstance("", ""))

                }
            }.lparams(width = wrapContent, height = wrapContent)
            button("BLE") {
                onClick {
                    owner.replaceFragment(Main.Ids.main_frame, FastBleFragment())

                }
            }.lparams(width = wrapContent, height = wrapContent)

        }
    }
}