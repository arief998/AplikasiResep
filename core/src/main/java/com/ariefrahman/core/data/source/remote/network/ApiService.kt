package com.ariefrahman.core.data.source.remote.network

import com.ariefrahman.core.data.source.remote.response.RecipeResponse
import retrofit2.http.GET

interface ApiService {
    @GET("/api/recipes")
    fun getRecipe(): RecipeResponse
}