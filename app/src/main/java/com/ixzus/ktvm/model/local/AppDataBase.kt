package com.ixzus.ktvm.model.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.ixzus.ktvm.model.data.User


@Database(entities = arrayOf(
    User::class,
    GankDao::class
    //add
), version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun androidDao(): GankDao
    //add

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getAppDadaBase(context: Context): AppDataBase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE
                            ?: buildDataBase(context).also { INSTANCE = it }
                }


        private fun buildDataBase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        AppDataBase::class.java,
                        "ktvm.db").build()

    }
}