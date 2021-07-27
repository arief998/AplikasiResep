package com.ariefrahman.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ariefrahman.core.data.source.local.entity.RecipeEntity

@Database(entities = [RecipeEntity::class], version = 2, exportSchema = false)
abstract class RecipeDatabase: RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}