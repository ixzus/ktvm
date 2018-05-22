package com.ixzus.ktvm.di

import com.ixzus.ktvm.App
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by ixzus on 2018/5/21
 * Email: iandroid@foxmail.com
 * Desc:
 */
@Component(modules = arrayOf(AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AllActivityModule::class,
        AllFragmentModule::class))

interface AppComponent {
    fun inject(app: App)
}