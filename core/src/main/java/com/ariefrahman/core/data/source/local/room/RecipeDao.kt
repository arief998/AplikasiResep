package com.ariefrahman.core.data.source.local.room

import androidx.room.*
import com.ariefrahman.core.data.source.local.entity.RecipeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNewRecipe(recipe: List<RecipeEntity>)

    @Delete
    fun delete(recipe: RecipeEntity)

    @Query("SELECT * FROM RecipeEntity")
    fun getAllRecipe(): Flow<List<RecipeEntity>>
}