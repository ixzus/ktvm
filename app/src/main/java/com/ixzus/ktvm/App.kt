package com.ixzus.ktvm

import android.app.Application
import com.ixzus.ktvm.ext.DelegatesExt
import com.ixzus.ktvm.log.ReleaseTree
import com.ixzus.ktvm.log.ThreadAwareDebugTree
import io.objectbox.BoxStore
import timber.log.Timber


/**
 * Created by Administrator on 2018/3/1.
 */
class App : Application() {

    companion object {
        var instance by DelegatesExt.notNullSingleValue<App>()
//        private var instance by DelegatesExt.notNullSingleValue<App>()
//        private var instance :App by NotNullSingleValueVar()
    }
   lateinit var boxStore: BoxStore

    override fun onCreate() {
        super.onCreate()
        instance = this


        if (BuildConfig.DEBUG) {
            Timber.plant(ThreadAwareDebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }

}