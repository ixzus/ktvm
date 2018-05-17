package com.ixzus.ktvm.model.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.ixzus.ktvm.model.data.GankModel

@Dao
interface GankDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(androids: List<GankModel.AndroidResult>)

    @Query("SELECT * FROM android")
    fun findAll(): LiveData<GankModel.AndroidResult>
}