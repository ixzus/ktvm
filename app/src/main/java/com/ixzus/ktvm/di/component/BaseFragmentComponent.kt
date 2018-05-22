package com.ixzus.ktvm.di.component

import com.ixzus.ktvm.view.base.BaseFragment
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

/**
 * Created by ixzus on 2018/5/21
 * Email: iandroid@foxmail.com
 * Desc:
 */
@Subcomponent(modules = arrayOf(AndroidInjectionModule::class))
interface BaseFragmentComponent : AndroidInjector<BaseFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<BaseFragment>() {

    }
}