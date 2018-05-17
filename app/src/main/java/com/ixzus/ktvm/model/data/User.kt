package com.ixzus.ktvm.model.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "users")
data class User(@PrimaryKey
                var uid: Int,
                var nick: String,
                var phong: String)