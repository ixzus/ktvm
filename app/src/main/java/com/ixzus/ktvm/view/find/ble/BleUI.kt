package com.ixzus.ktvm.view.find.ble

import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

/**
 * Created by Administrator on 2018/3/28.
 */
class BleUI : AnkoComponent<FastBleFragment> {
    override fun createView(ui: AnkoContext<FastBleFragment>) = with(ui) {
        verticalLayout() {
            textView()
        }
    }
}