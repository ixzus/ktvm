package com.ixzus.ktvm.view.base


import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ixzus.ktvm.helper.presenter.Presenter
import org.jetbrains.anko.support.v4.act


abstract class BaseVBFragment<VB : ViewDataBinding> : BaseFragment(), Presenter {

    protected lateinit var mBinding: VB

    protected lateinit var mContext: Context

    protected var lazyLoad = false

    protected var visible = false

    protected var isPrepared: Boolean = false

    protected var hasLoadOnce: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mContext = act
        initView()
        if (lazyLoad) {
            lazyLoad()
        } else {
            loadData(true)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), null, false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (userVisibleHint) {
            visible = true
            onVisible()
        } else {

            visible = false
            onInvisible()
        }
    }

    protected fun onInvisible() {}

    open protected fun onVisible() {
        lazyLoad()
    }

    abstract fun initView()
    abstract fun loadData(isRefresh: Boolean)
    abstract fun getLayoutId(): Int

    open fun lazyLoad() {}


}
