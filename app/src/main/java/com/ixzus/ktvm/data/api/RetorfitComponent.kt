package com.ixzus.ktvm.data.api

import com.ixzus.ktvm.data.repository.ReadRepository
import com.ixzus.ktvm.data.repository.ReadViewModel
import com.ixzus.ktvm.ui.read.ReadFragment
import dagger.Component
import javax.inject.Singleton


/**
 * Created by Administrator on 2018/3/13.
 */
@Singleton
@Component(modules = arrayOf(RetrofitModule::class))
//@Subcomponent(modules = arrayOf(RetrofitModule::class))
interface RetorfitComponent {

    fun inject(readFragment: ReadFragment)

    fun inject(readRepository: ReadRepository)

    fun inject(readViewModel: ReadViewModel)
}
