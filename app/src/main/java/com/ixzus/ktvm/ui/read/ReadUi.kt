package com.ixzus.ktvm.ui.read

import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.support.v7.widget.LinearLayoutManager
import com.ixzus.ktvm.R
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.swipeRefreshLayout

/**
 * Created by Administrator on 2018/3/6.
 */
class ReadUi : AnkoComponent<ReadFragment> {
    override fun createView(ui: AnkoContext<ReadFragment>) = with(ui) {
        verticalLayout {
            toolbar {
                setBackgroundColor(resources.getColor(R.color.colorPrimary))
                (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP).let { elevation = 4f }
                title = "阅读"
//                setTitleTextColor()



            }
            swipeRefreshLayout {
                setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN)
//                onRefresh {
//                }

                owner.recyclerView = recyclerView {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                }
            }
        }
    }
}