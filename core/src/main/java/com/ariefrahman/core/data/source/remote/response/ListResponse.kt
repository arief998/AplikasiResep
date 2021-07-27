package com.ariefrahman.core.data.source.remote.response

data class ListResponse<T>(
    val method: String,
    val status: Boolean,
    val results: List<T>
)
