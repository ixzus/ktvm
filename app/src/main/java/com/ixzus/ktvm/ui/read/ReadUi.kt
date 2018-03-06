package com.ixzus.ktvm.ui.read

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout

/**
 * Created by Administrator on 2018/3/6.
 */
class ReadUi<T> : AnkoComponent<T> {
    override fun createView(ui: AnkoContext<T>) = with(ui) {
        swipeRefreshLayout {
            setColorSchemeColors(Color.RED,Color.BLUE,Color.GREEN)
            onRefresh {
            }

            recyclerView {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
            }
        }
    }
}