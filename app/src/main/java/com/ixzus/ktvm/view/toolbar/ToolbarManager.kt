package com.ixzus.ktvm.view.toolbar

import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.ixzus.ktvm.R
import com.ixzus.ktvm.helper.ext.ctx
import com.ixzus.ktvm.helper.ext.slideEnter
import com.ixzus.ktvm.helper.ext.slideExit

/**
 * Created by Administrator on 2018/3/1.
 */
interface ToolbarManager {
    val toolbar: Toolbar

    var toolbarTitle: String
        get() = toolbar.title.toString()
        set(value) {
            toolbar.title = value
        }

    fun initToolbar() {
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener {
//            when (it.itemId) {
//                R.id.action_settings-> toolbar.ctx.toast("设置")
//                else -> toolbar.ctx.toast("其它")
//            }
            true
        }
    }

    fun enableHomeAsUp(up: () -> Unit) {
        toolbar.navigationIcon = createUpDrawable()
        toolbar.setNavigationOnClickListener { up() }
    }

    private fun createUpDrawable() = DrawerArrowDrawable(toolbar.ctx).apply { progress = 1f }


    fun attachToScroll(recyclerView: RecyclerView){
        recyclerView.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(dy>0) toolbar.slideExit()
                else toolbar.slideEnter()
            }
        })
    }


}