package com.ixzus.ktvm.helper.presenter

import android.view.View
import com.ixzus.ktvm.viewmodel.StateModel

interface ListPresenter : Presenter {

    val state: StateModel

    fun loadData(isRefresh: Boolean)

    override fun onClick(v: View?)
}