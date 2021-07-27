package com.ariefrahman.core.domain.usecase

import com.ariefrahman.core.data.source.Resource
import com.ariefrahman.core.domain.model.Category
import com.ariefrahman.core.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeUseCase {
    fun getNewRecipe(): Flow<Resource<List<Recipe>>>

    suspend fun getCategory(): Flow<Resource<List<Category>>>
}