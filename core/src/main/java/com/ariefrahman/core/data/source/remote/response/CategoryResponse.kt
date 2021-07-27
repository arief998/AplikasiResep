package com.ariefrahman.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class CategoryResponse (
    @field:SerializedName("category")
    val category: String,

    @field:SerializedName("url")
    val url: String,

    @field:SerializedName("key")
    val key: String
)