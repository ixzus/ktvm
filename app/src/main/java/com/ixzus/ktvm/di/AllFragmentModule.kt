package com.ixzus.ktvm.di

import com.ixzus.ktvm.di.component.BaseFragmentComponent
import com.ixzus.ktvm.di.module.ReadFragmentModule
import com.ixzus.ktvm.di.scope.FragmentScope
import com.ixzus.ktvm.view.read.ReadFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by ixzus on 2018/5/21
 * Email: iandroid@foxmail.com
 * Desc:
 */
@Module(subcomponents = arrayOf(BaseFragmentComponent::class))
abstract class AllFragmentModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(ReadFragmentModule::class))
    abstract fun contributeFragmentInjector(): ReadFragment
}