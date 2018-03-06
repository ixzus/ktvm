package com.ixzus.ktvm.net

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by Administrator on 2018/3/6.
 */
interface ApiService {

    @GET("contributors")
    fun getContributor(): Call<List<Contributor>>

    companion object {
        const val END_POINT = "https://meiriyiwen.com/"

        const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
        const val BASE_URL: String = "https://api.github.com/repos/JetBrains/kotlin/"

        fun create(userId: String): ApiService {
            val gson = GsonBuilder()
                    .setDateFormat(DATE_FORMAT)
                    .create()
            val client = OkHttpClient.Builder().addInterceptor { chain ->
                val newRequest = chain.request()
                        .newBuilder()
                        .addHeader("Authorization", "Bearer $userId")
                        .addHeader("Accept", "application/json")
                        .build()
                chain.proceed(newRequest)
            }
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}