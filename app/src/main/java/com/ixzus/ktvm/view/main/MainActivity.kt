package com.ixzus.ktvm.view.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ixzus.ktvm.helper.ext.replaceFragment
import com.ixzus.ktvm.view.base.BaseActivity
import com.ixzus.ktvm.view.splash.SplashFragment
import org.jetbrains.anko.setContentView

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Main().setContentView(this)
        replaceFragment(Main.main_frame, SplashFragment.newInstance("", ""))
    }
}
