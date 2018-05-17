package com.ixzus.ktvm.model.remote.net

import com.ixzus.ktvm.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Administrator on 2018/3/6.
 */
interface ApiService {


    companion object {
        const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
        const val BASE_URL: String = "http://gank.io/api/data/"

        fun create(userId: String): ApiService {
//            val gson = GsonBuilder()
//                    .setDateFormat(DATE_FORMAT)
//                    .create()

            val builder = OkHttpClient.Builder()
//            builder.addInterceptor { chain ->
//                val newRequest = chain.request()
//                        .newBuilder()
//                        .addHeader("Authorization", "Bearer $userId")
//                        .addHeader("Accept", "application/json")
//                        .build()
//                chain.proceed(newRequest)
//            }
            if (BuildConfig.DEBUG) {
                // Log信息拦截器
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                //设置 Debug Log 模式
                builder.addInterceptor(loggingInterceptor)
            }
            val client = builder.build()
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}