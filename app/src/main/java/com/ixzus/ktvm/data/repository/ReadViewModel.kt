package com.ixzus.ktvm.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.ixzus.ktvm.data.model.DataResult
import com.ixzus.ktvm.data.model.GankModel

/**
 * Created by Administrator on 2018/3/14.
 */
class ReadViewModel : ViewModel() {
    private lateinit var data: LiveData<DataResult<List<GankModel.AndroidResult>>>
    private lateinit var loading: LiveData<Boolean>

    fun isLoading(readRepository: ReadRepository): LiveData<Boolean> {
        return readRepository.isLoading()
    }

    fun getAndroid(readRepository: ReadRepository, pageSize: String, pageNo: String): LiveData<List<GankModel.AndroidResult>> {
//        if (data == null) {
//        data = MutableLiveData<List<GankModel.AndroidResult>>()
//        data = loadAndroid(readRepository, pageSize, pageNo)
//        }
//        return data
        return loadAndroid(readRepository, pageSize, pageNo)
    }

    private fun loadAndroid(readRepository: ReadRepository, pageSize: String, pageNo: String): LiveData<List<GankModel.AndroidResult>> {
        return readRepository.getAndroid(pageSize, pageNo)
    }
}