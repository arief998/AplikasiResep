package com.ariefrahman.core.domain.usecase

import com.ariefrahman.core.data.source.Resource
import com.ariefrahman.core.domain.model.Category
import com.ariefrahman.core.domain.model.Recipe
import com.ariefrahman.core.domain.repository.IRecipeRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow

class RecipeInteractor(private val recipeRepository: IRecipeRepository): RecipeUseCase {
    override fun getNewRecipe(): Flow<Resource<List<Recipe>>> {
        return recipeRepository.getNewRecipe()
    }

    override suspend fun getCategory(): Flow<Resource<List<Category>>> {
        return coroutineScope { recipeRepository.getCategory() }
    }
}