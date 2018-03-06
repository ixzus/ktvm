package com.ixzus.ktvm

import android.app.Application
import com.ixzus.ktvm.ext.DelegatesExt


/**
 * Created by Administrator on 2018/3/1.
 */
class App : Application() {

    companion object {
        var instance by DelegatesExt.notNullSingleValue<App>()
//        private var instance by DelegatesExt.notNullSingleValue<App>()
//        private var instance :App by NotNullSingleValueVar()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}