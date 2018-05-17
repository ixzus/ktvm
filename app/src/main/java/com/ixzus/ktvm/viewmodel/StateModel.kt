package com.ixzus.ktvm.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableBoolean
import com.ixzus.ktvm.App
import com.ixzus.ktvm.R
import com.ixzus.ktvm.helper.annotation.EmptyState
import com.ixzus.ktvm.model.remote.exception.EmptyException

class StateModel : BaseObservable() {
    val app = App.instance
    val loading = ObservableBoolean(false)
    val loadMore = ObservableBoolean(false)
    val empty = ObservableBoolean(false)
    fun canLoadMore() = loadMore.get() && !loading.get()
    var emptyState = EmptyState.NORMAL
        @Bindable get
        set(@EmptyState value) {
            field = value
//            notifyPropertyChanged(BR.currentStateLabel)
        }

    fun showEmpty(emptyType:Int){
        if(!empty.get()){
            empty.set(true)
        }
        throw EmptyException(emptyType)
    }
    fun hideEmpty(){
        if(empty.get()){
            empty.set(false)
        }
    }

    @Bindable
    fun getCurrentStateLabel():String{
        var resId = R.string.app_name
        when(emptyState){}
        return app.getString(resId)
    }
}