package com.ixzus.ktvm.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.ixzus.ktvm.data.api.GankService
import com.ixzus.ktvm.data.model.GankModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by Administrator on 2018/3/6.
 */
@Singleton
class ReadRepository @Inject constructor(var gankService: GankService) {
    private lateinit var loading: MutableLiveData<Boolean>

    fun isLoading(): LiveData<Boolean> = loading

    fun getAndroid(pageSize: String, pageNo: String): LiveData<List<GankModel.AndroidResult>> {
        var data = MutableLiveData<List<GankModel.AndroidResult>>()
        loading = MutableLiveData<Boolean>()
        loading.value = true
        gankService.getAndroid(pageSize, pageNo)
                .subscribeOn(Schedulers.io())
                .map { it.results }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    data.value = it
                    loading.value = false
                }
        return data
    }
}