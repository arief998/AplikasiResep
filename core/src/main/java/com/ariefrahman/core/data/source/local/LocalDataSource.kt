package com.ariefrahman.core.data.source.local

import com.ariefrahman.core.data.source.local.entity.RecipeEntity
import com.ariefrahman.core.data.source.local.room.RecipeDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(
    private val recipeDao: RecipeDao
) {
    suspend fun insert(recipeEntity: List<RecipeEntity>){
        recipeDao.insertNewRecipe(recipeEntity)
    }

    fun getAllRecipe(): Flow<List<RecipeEntity>>{
        return recipeDao.getAllRecipe()
    }
}