package com.ixzus.ktvm.model.remote

import com.ixzus.ktvm.view.read.ReadFragment
import dagger.Component


/**
 * Created by Administrator on 2018/3/13.
 */
//@Singleton
@Component(modules = arrayOf(NetModule::class))
//@Subcomponent(modules = arrayOf(NetModule::class))
interface NetComponent {

    fun inject(readFragment: ReadFragment)

//    fun inject(gankRepository: GankRepository)

//    fun inject(readViewModel: ReadViewModel)
}
