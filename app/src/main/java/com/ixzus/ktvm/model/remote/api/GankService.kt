package com.ixzus.ktvm.model.remote.api

import com.ixzus.ktvm.model.data.DataResult
import com.ixzus.ktvm.model.data.GankModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Administrator on 2018/3/9.
 */
interface GankService {

    @GET("Android/{pageSize}/{pageNo}")
    fun getAndroid(@Path("pageSize") pageSize: String, @Path("pageNo") pageNo: String): Observable<DataResult<List<GankModel.AndroidResult>>>
//    fun getAndroid(@Path("pageSize") pageSize: String, @Path("pageNo") pageNo: String): Call<DataResult<AndroidResult>>

//    @GET("福利/{pageSize}/{pageNo}")
//    fun getFolies(@Path("pageSize") pageSize: String, @Path("pageNo") pageNo: String): Call<DataResult<GankModel.FoliesResult>>

}