package com.ariefrahman.core.data.source

import com.ariefrahman.core.data.source.local.LocalDataSource
import com.ariefrahman.core.data.source.remote.RemoteDataSource
import com.ariefrahman.core.data.source.remote.response.ApiResponse
import com.ariefrahman.core.data.source.remote.response.CategoryResponse
import com.ariefrahman.core.data.source.remote.response.RecipeResponse
import com.ariefrahman.core.domain.model.Category
import com.ariefrahman.core.domain.model.Recipe
import com.ariefrahman.core.domain.repository.IRecipeRepository
import com.ariefrahman.core.utils.DataMapper
import kotlinx.coroutines.flow.*

open class RecipeRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): IRecipeRepository {
    override fun getNewRecipe(): Flow<Resource<List<Recipe>>> {
        return object : NetworkBoundSource<List<Recipe>, List<RecipeResponse>>() {
            override fun loadFromDB(): Flow<List<Recipe>> {
                return localDataSource.getAllRecipe().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Recipe>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<List<RecipeResponse>>> {
                return remoteDataSource.getNewRecipe()
            }

            override suspend fun saveCallResult(data: List<RecipeResponse>) {
                val recipeList = DataMapper.mapResopneToEntities(data)
                localDataSource.insert(recipeList)
            }
        }.asFlow()
    }

    override suspend fun getCategory(): Flow<Resource<List<Category>>> {
        val result: Flow<Resource<List<Category>>> = flow {
            val response: Flow<ApiResponse<List<CategoryResponse>>> = remoteDataSource.getCategory()
            when(val apiResponse = response.first()){
                is ApiResponse.Success -> {
                    val data = apiResponse.data
                    val mapper = DataMapper.mapCategoryResponseToDomain(data)
                    emit(Resource.Success(mapper))
                }
            }
        }
        return result
    }
}