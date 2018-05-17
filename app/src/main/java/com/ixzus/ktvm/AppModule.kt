package com.ixzus.ktvm

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ixzus on 2018/5/17
 * Email: iandroid@foxmail.com
 * Desc:
 */
@Module
class AppModule(var app: App) {
    @Provides
    @Singleton
    fun providesApp(): App = app
}