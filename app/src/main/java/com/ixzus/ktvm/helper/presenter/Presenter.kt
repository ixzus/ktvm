package com.ixzus.ktvm.helper.presenter

import android.view.View

interface Presenter : View.OnClickListener {
    override fun onClick(v: View?)
}