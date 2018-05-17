package com.ixzus.ktvm.model.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Administrator on 2018/3/8.
 */
object GankModel {

    @Entity(tableName = "android")
    data class AndroidResult(
            @PrimaryKey
            var _id: String,
            var createdAt: String,
            var desc: String,
            var images: List<String>,
            var publishedAt: String,
            var source: String,
            var type: String,
            var url: String,
            var used: Boolean,
            var who: String
    )

    data class FoliesResult(
            @PrimaryKey
            var _id: String,
            var createdAt: String,
            var desc: String,
            var publishedAt: String,
            var source: String,
            var type: String,
            var url: String,
            var used: Boolean,
            var who: String
    )
}