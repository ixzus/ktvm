package com.ixzus.ktvm.model.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.ixzus.ktvm.model.data.GankModel
import javax.inject.Inject

/**
 * Created by Administrator on 2018/3/14.
 */
class ReadViewModel @Inject constructor(private val gankRepository: GankRepository) : ViewModel() {

    fun isLoading(): LiveData<Boolean> {
        return gankRepository.isLoading()
    }

    fun getAndroid(pageSize: String, pageNo: String): LiveData<List<GankModel.AndroidResult>> {
        return gankRepository.getAndroid(pageSize, pageNo)
    }

}