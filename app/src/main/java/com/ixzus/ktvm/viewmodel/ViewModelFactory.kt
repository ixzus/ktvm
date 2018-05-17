package com.ixzus.ktvm.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ixzus.ktvm.model.repository.GankRepository
import com.ixzus.ktvm.model.repository.ReadViewModel

class ViewModelFactory(private val gankRepository: GankRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReadViewModel::class.java)) {
            return ReadViewModel(gankRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}