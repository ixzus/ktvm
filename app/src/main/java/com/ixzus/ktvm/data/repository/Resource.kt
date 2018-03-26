package com.ixzus.ktvm.data.repository

class Resource<T> private constructor(val data: T?, val message: String?) {
    companion object {

        fun <T> success(data: T): Resource<T> {
            return Resource(data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(data, null)
        }
    }
}