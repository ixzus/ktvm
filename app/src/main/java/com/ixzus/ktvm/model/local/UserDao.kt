package com.ixzus.ktvm.model.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.ixzus.ktvm.model.data.User


@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM users ")
    fun find(): LiveData<List<User>>


}