package com.ixzus.ktvm.log

import android.util.Log

class ReleaseTree : ThreadAwareDebugTree() {
    override fun isLoggable(tag: String?, priority: Int): Boolean {
        return if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
            false
        } else true
    }

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (!isLoggable(tag, priority)) {
            return
        }
        super.log(priority, tag, message, t)
    }
}