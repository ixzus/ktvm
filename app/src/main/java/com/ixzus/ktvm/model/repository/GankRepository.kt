package com.ixzus.ktvm.model.repository

import com.ixzus.ktvm.model.remote.api.GankService
import javax.inject.Inject


/**
 * Created by Administrator on 2018/3/6.
 */
class GankRepository @Inject constructor(val gankService: GankService) {
//        private lateinit var loading: MutableLiveData<Boolean>
//
//    fun isLoading(): LiveData<Boolean> = loading
//
//    fun getAndroid(pageSize: String, pageNo: String): LiveData<List<GankModel.AndroidResult>> {
//        var data = MutableLiveData<List<GankModel.AndroidResult>>()
//        loading = MutableLiveData<Boolean>()
//        loading.value = true
//        gankService.getAndroid(pageSize, pageNo)
//                .subscribeOn(Schedulers.io())
//                .map { it.results }
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe {
//                    data.value = it
//                    loading.value = false
//                }
//        return data
//    }
    fun getAndroid(pageSize: String, pageNo: String) = gankService.getAndroid(pageSize,pageNo)
}