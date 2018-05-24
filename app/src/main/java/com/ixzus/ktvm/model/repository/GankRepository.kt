package com.ixzus.ktvm.model.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.ixzus.ktvm.model.data.GankModel
import com.ixzus.ktvm.model.remote.NetObserver
import com.ixzus.ktvm.model.remote.api.GankService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * Created by Administrator on 2018/3/6.
 */
class GankRepository @Inject constructor(val gankService: GankService) {
    private lateinit var loading: MutableLiveData<Boolean>

    fun isLoading(): LiveData<Boolean> = loading


    fun getAndroid(pageSize: String, pageNo: String): LiveData<List<GankModel.AndroidResult>> {
        var data = MutableLiveData<List<GankModel.AndroidResult>>()
        loading = MutableLiveData<Boolean>()
        loading.value = false
//        gankService.getAndroid(pageSize, pageNo)
//                .subscribeOn(Schedulers.io())
//                .map { it.results }
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe {
//                    data.value = it
//                    loading.value = false
//                }
        gankService.getAndroid(pageSize, pageNo)
                .subscribeOn(Schedulers.io())
                .map { it.results }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : NetObserver<List<GankModel.AndroidResult>>(1) {
                    override fun onStart(which: Int) {
                        loading.value = true
                    }

                    override fun onSuccess(which: Int, t: List<GankModel.AndroidResult>) {
                        loading.value = false
                        data.value = t
                    }

                    override fun onFaile(which: Int, msg: String) {
                        loading.value = false
                    }
                })
//        gankService.getAndroid(pageSize, pageNo)
//                .subscribeOn(Schedulers.io())
//                .map { it.results }
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeBy(
//                        onNext = {
//                            data.value = it
//                        },
//                        onError = {
//                            loading.value = false
//                        },
//                        onComplete = {
//                            loading.value = false
//                        }
//                )
        return data
    }
}