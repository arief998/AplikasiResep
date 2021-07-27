package com.ariefrahman.myrecipe.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ariefrahman.core.data.source.Resource
import com.ariefrahman.core.domain.model.Category
import com.ariefrahman.core.domain.model.Recipe
import com.ariefrahman.core.domain.usecase.RecipeUseCase
import kotlinx.coroutines.coroutineScope

class HomeViewModel(private val useCase: RecipeUseCase) : ViewModel() {

    fun getNewRecipe(): LiveData<Resource<List<Recipe>>>{
        return useCase.getNewRecipe().asLiveData()
    }

    suspend fun getCategory(): LiveData<Resource<List<Category>>>{
        return coroutineScope { useCase.getCategory().asLiveData() }
    }
}