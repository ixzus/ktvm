package com.ixzus.ktvm.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ixzus.ktvm.ext.replaceFragment
import com.ixzus.ktvm.ui.splash.SplashFragment
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Main().setContentView(this)
        replaceFragment(Main.main_frame, SplashFragment.newInstance("", ""))
    }
}
