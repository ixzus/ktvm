package com.ixzus.ktvm.view.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var mContext: Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        mContext = this
        initView()
        loadData()
    }

    abstract fun loadData()
    abstract fun initView()
    abstract fun getLayoutId(): Int
}