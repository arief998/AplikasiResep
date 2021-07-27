package com.ariefrahman.core.utils

import com.ariefrahman.core.data.source.local.entity.RecipeEntity
import com.ariefrahman.core.data.source.remote.response.CategoryResponse
import com.ariefrahman.core.data.source.remote.response.RecipeResponse
import com.ariefrahman.core.domain.model.Category
import com.ariefrahman.core.domain.model.Recipe

object DataMapper {
    fun mapEntitiesToDomain(list: List<RecipeEntity>): List<Recipe>{
        val dataArray = ArrayList<Recipe>()
        list.map {
            val recipe = Recipe(
                it.title,
                it.thumb,
                it.key,
                it.times,
                it.portion,
                it.dificulty,
                it.favorite
            )

            dataArray.add(recipe)
        }
        return dataArray
    }

    fun mapDomainToEntities(list: List<Recipe>): List<RecipeEntity>{
        val dataArray = ArrayList<RecipeEntity>()
        list.map {
            val recipeEntity = RecipeEntity(
                it.title,
                it.thumb,
                it.key,
                it.times,
                it.portion,
                it.dificulty,
                it.favorite
            )
            dataArray.add(recipeEntity)
        }
        return dataArray
    }

    fun mapResopneToEntities(list: List<RecipeResponse>): List<RecipeEntity>{
        val dataArray = ArrayList<RecipeEntity>()
        list.map {
            val recipeEntity = RecipeEntity(
                it.title,
                it.thumb,
                it.key,
                it.times,
                it.portion,
                it.dificulty,
            )
            dataArray.add(recipeEntity)
        }
        return dataArray
    }

    fun mapCategoryResponseToDomain(list: List<CategoryResponse>): List<Category>{
        val dataArray = ArrayList<Category>()
        list.map {
            val category = Category(
                it.category,
                it.url,
                it.key
            )
            dataArray.add(category)
        }
        return dataArray
    }
}