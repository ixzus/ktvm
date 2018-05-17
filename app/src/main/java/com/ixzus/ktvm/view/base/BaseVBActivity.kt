package com.ixzus.ktvm.view.base

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ixzus.ktvm.helper.presenter.Presenter

abstract class BaseVBActivity<VB : ViewDataBinding> : AppCompatActivity(), Presenter {

    protected lateinit var mBinding: VB
    protected lateinit var mContext: Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mContext = this
        initView()
        loadData()
    }

    abstract fun loadData()
    abstract fun initView()
    abstract fun getLayoutId(): Int
}