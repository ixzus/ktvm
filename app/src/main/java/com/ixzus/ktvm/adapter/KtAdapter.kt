package com.ixzus.ktvm.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.ixzus.ktvm.ext.inflate

/**
 * Created by Administrator on 2018/3/1.
 */
class KtAdapter<T>(val layoutResourceId: Int, var items: List<T>, val init: (View, T) -> Unit) :
        RecyclerView.Adapter<KtAdapter.ViewHolder<T>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<T> = ViewHolder(parent.inflate(layoutResourceId), init)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) = holder.bindData(items[position])


    class ViewHolder<in T>(view: View, val init: (View, T) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bindData(item: T) {
            with(item) {
                init(itemView, item)
            }
        }
    }
}