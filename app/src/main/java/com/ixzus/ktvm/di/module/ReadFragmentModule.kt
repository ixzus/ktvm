package com.ixzus.ktvm.di.module

import dagger.Module
import dagger.Provides

/**
 * Created by ixzus on 2018/5/21
 * Email: iandroid@foxmail.com
 * Desc:
 */
@Module
class ReadFragmentModule {

    @Provides
    fun provideName(): String = "dagger.android 666"

}
