package com.ixzus.ktvm.model.data

import android.support.annotation.Nullable


/**
 * Created by Administrator on 2018/3/8.
 */
data class DataResult<T>(@Nullable val error: Boolean = false, @Nullable val results: T)
