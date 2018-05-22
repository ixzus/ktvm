package com.ixzus.ktvm.di

import com.ixzus.ktvm.di.component.BaseActivityComponent
import dagger.Module

/**
 * Created by ixzus on 2018/5/21
 * Email: iandroid@foxmail.com
 * Desc:
 */
@Module(subcomponents = arrayOf(BaseActivityComponent::class))
abstract class AllActivityModule{

}