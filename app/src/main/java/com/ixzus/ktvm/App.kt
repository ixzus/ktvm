package com.ixzus.ktvm

import android.app.Application
import android.support.v4.app.Fragment
import com.ixzus.ktvm.di.DaggerAppComponent
import com.ixzus.ktvm.helper.ext.DelegatesExt
import com.ixzus.ktvm.helper.log.ReleaseTree
import com.ixzus.ktvm.helper.log.ThreadAwareDebugTree
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.objectbox.BoxStore
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by Administrator on 2018/3/1.
 */
class App : Application(), HasSupportFragmentInjector {

    companion object {
        var instance by DelegatesExt.notNullSingleValue<App>()
//        private var instance by DelegatesExt.notNullSingleValue<App>()
//        private var instance :App by NotNullSingleValueVar()
    }


    override fun onCreate() {
        super.onCreate()
        instance = this


        if (BuildConfig.DEBUG) {
            Timber.plant(ThreadAwareDebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }

        DaggerAppComponent.create().inject(this)
    }

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector
}