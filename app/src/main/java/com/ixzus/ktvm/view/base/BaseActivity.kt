package com.ixzus.ktvm.view.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var mContext: Context


    override fun onCreate(savedInstanceState: Bundle?) {
//        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        mContext = this
//        setContentView(getLayoutId())
//        initView()
//        loadData()
    }

//    abstract fun loadData()
//    abstract fun initView()
//    abstract fun getLayoutId(): Int
}