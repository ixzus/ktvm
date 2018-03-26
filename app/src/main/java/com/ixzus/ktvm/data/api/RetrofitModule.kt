package com.ixzus.ktvm.data.api

import com.ixzus.ktvm.data.repository.ReadRepository
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber

/**
 * Created by Administrator on 2018/3/9.
 */
@Module
class RetrofitModule {
    @Provides
    fun provideMoshi() =
            Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()

//    @Provides
//    fun provideGson() = GsonBuilder().create()

    @Provides
    fun provideHttpLog(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor { msg ->
            Timber.i(msg)
        }
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Provides
    fun provideOkhttp(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .build()


    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit =
            Retrofit.Builder()
                    .baseUrl("http://gank.io/api/data/")
                    .client(okHttpClient)
//                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .addConverterFactory(MoshiConverterFactory.create())
//                    .addConverterFactory(GsonConverterFactory.create(provideGson()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

    @Provides
    fun provideGankService(retrofit: Retrofit): GankService =
            retrofit.create(GankService::class.java)


//    @Provides
//    fun provideVmFactory(viewModelFactory: ReadViewModelFactory): ViewModelProvider.Factory {
//        return viewModelFactory
//    }

    @Provides
    fun provideReadRepo(gankService: GankService): ReadRepository {
        return ReadRepository(gankService)
    }

}