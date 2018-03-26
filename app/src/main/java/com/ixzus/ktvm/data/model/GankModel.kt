package com.ixzus.ktvm.data.model

/**
 * Created by Administrator on 2018/3/8.
 */
object GankModel{

     data class AndroidResult(
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