package com.ixzus.ktvm.helper.log

import timber.log.Timber

open class ThreadAwareDebugTree : Timber.DebugTree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        var tag = tag
        if (tag != null) {
            val threadName = Thread.currentThread().name
            tag = "<$threadName> $tag"
        }
        super.log(priority, tag, message, t)
    }

    override fun createStackElementTag(element: StackTraceElement): String? {
        return super.createStackElementTag(element) + "(Line " + element.lineNumber + ")"  //日志显示行号
    }
}