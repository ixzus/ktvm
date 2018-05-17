package com.ixzus.ktvm.viewmodel

import com.ixzus.ktvm.model.repository.GankRepository

object Injection {

    fun provideViewModelFactory(gankRepository: GankRepository): ViewModelFactory {
        return ViewModelFactory(gankRepository)
    }
}