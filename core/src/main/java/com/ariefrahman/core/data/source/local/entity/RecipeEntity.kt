package com.ariefrahman.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class RecipeEntity (
    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "thumb")
    var thumb: String,

    @PrimaryKey
    @ColumnInfo(name = "key")
    var key: String,

    @ColumnInfo(name = "times")
    var times: String,

    @ColumnInfo(name = "portion")
    var portion: String,

    @ColumnInfo(name = "dificulty")
    var dificulty: String,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false
)