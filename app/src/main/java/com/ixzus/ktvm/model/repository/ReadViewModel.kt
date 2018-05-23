package com.ixzus.ktvm.model.repository

import android.arch.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created by Administrator on 2018/3/14.
 */
class ReadViewModel @Inject constructor(private val gankRepository: GankRepository) : ViewModel() {

//    fun isLoading(): LiveData<Boolean> {
//        return gankRepository.isLoading()
//    }

//    fun getAndroid(pageSize: String, pageNo: String): LiveData<List<GankModel.AndroidResult>> {
//        if (data == null) {
//        data = MutableLiveData<List<GankModel.AndroidResult>>()
//        data = loadAndroid(gankRepository, pageSize, pageNo)
//        }
//        return data
//        return loadAndroid(pageSize, pageNo)
//    }

    //    private fun loadAndroid(pageSize: String, pageNo: String): LiveData<List<GankModel.AndroidResult>> {
//        return gankRepository.getAndroid(pageSize, pageNo)
//    }

    fun getAndroid(pageSize: String, pageNo: String) = gankRepository.getAndroid(pageSize, pageNo)


}