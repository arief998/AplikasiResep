package com.ariefrahman.core.data.source.remote.response

data class RecipeResponse(
    val method: String,
    val status: Boolean,
    val results: List<RecipeItem>
)
