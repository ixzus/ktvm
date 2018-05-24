package com.ixzus.ktvm.model.remote

import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.net.UnknownServiceException

/**
 * Created by ixzus on 2018/5/23
 * Email: iandroid@foxmail.com
 * Desc:
 */
open abstract class NetObserver<T>(private var which: Int) : Observer<T> {
    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
        onStart(which)
    }

    override fun onNext(t: T) {
        onSuccess(which, t)
    }

    override fun onError(e: Throwable) {
        var code = 0
        var RESPONSE_CODE_FAILED: Int = -1
        var errorMessage = "未知错误"
        if (e is HttpException) {
            val httpException = e as HttpException
            val meg = httpException.response().toString()
            code = httpException.code()
            errorMessage = httpException.message ?: ""
        } else if (e is SocketTimeoutException) {  //VPN open
            code = RESPONSE_CODE_FAILED
            errorMessage = "服务器响应超时"
        } else if (e is ConnectException) {
            code = RESPONSE_CODE_FAILED
            errorMessage = "网络连接异常，请检查网络"
        } else if (e is RuntimeException) {
            code = RESPONSE_CODE_FAILED
            errorMessage = "运行时错误"
        } else if (e is UnknownHostException) {
            code = RESPONSE_CODE_FAILED
            errorMessage = "无法解析主机，请检查网络连接"
        } else if (e is UnknownServiceException) {
            code = RESPONSE_CODE_FAILED
            errorMessage = "未知的服务器错误"
        } else if (e is IOException) {  //飞行模式等
            code = RESPONSE_CODE_FAILED
            errorMessage = "没有网络，请检查网络连接"
        }
        dispatchErrCode(code, errorMessage)
    }

    fun dispatchErrCode(code: Int, message: String) {
        when (code) {
//            302, 401, 404 -> {
            302, 401 -> {
                //token
                onFaile(999, message)
            }
            500, 502 -> {
                //服务器开小差,努力抢修中...
                onFaile(which, message)
            }
            else -> {
                onFaile(which, message)
            }
        }
    }

    abstract fun onStart(which: Int)

    abstract fun onSuccess(which: Int, t: T)

    abstract fun onFaile(which: Int, msg: String)
}