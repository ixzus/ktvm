package com.ixzus.ktvm.helper.ext

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

/**
 * Created by Administrator on 2018/3/6.
 */
inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

fun AppCompatActivity.addFragment(frameId: Int,fragment: Fragment) {
    supportFragmentManager.inTransaction { add(frameId, fragment) }
}


fun AppCompatActivity.replaceFragment(frameId: Int,fragment: Fragment) {
    supportFragmentManager.inTransaction { replace(frameId, fragment) }
}

fun Fragment.addFragment(frameId: Int,fragment: Fragment) {
    activity?.supportFragmentManager?.inTransaction { add(frameId, fragment) }
}

fun Fragment.replaceFragment(frameId: Int,fragment: Fragment) {
    activity?.supportFragmentManager?.inTransaction { replace(frameId, fragment) }
}