package com.ixzus.ktvm.di.component

import com.ixzus.ktvm.view.base.BaseActivity
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

/**
 * Created by ixzus on 2018/5/21
 * Email: iandroid@foxmail.com
 * Desc:
 */
@Subcomponent(modules = arrayOf(AndroidInjectionModule::class))
interface BaseActivityComponent : AndroidInjector<BaseActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<BaseActivity>() {

    }
}