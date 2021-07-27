package com.ariefrahman.core.data.source.remote.network

import com.ariefrahman.core.data.source.remote.response.CategoryResponse
import com.ariefrahman.core.data.source.remote.response.ListResponse
import com.ariefrahman.core.data.source.remote.response.RecipeResponse
import retrofit2.http.GET

interface ApiService {
    @GET("api/recipes")
    suspend fun getRecipe(): ListResponse<RecipeResponse>

    @GET("/api/categorys/recipes")
    suspend fun getCategory(): ListResponse<CategoryResponse>
}