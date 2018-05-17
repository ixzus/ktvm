package com.ixzus.ktvm.model.remote.net

/**
 * Created by Administrator on 2018/3/9.
 */
abstract class ApiCallBack<T> {

    abstract fun onSuccess(data: T)

    abstract fun onError(code: Int, errMessage: String)

}