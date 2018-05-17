package com.ixzus.ktvm.view.read

import android.graphics.Color
import android.os.Build
import android.support.v7.widget.LinearLayoutManager
import com.ixzus.ktvm.R
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.coroutines.experimental.asReference
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout
import org.jetbrains.anko.toolbar
import org.jetbrains.anko.verticalLayout

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
            owner.swipeRefreshLayout = swipeRefreshLayout {
                setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN)
                onRefresh {
//                    val ref = asReference()
                    async(UI){
                        delay(300L)
                        isRefreshing = false
                        owner.refreshUI()
                    }

                }

                owner.recyclerView = recyclerView {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                }
            }
        }
    }
}