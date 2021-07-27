package com.ariefrahman.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("thumb")
    val thumb: String,

    @field:SerializedName("key")
    val key: String,

    @field:SerializedName("times")
    val times: String,

    @field:SerializedName("portion")
    val portion: String,

    @field:SerializedName("dificulty")
    val dificulty: String
)
