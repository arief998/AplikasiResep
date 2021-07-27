package com.ariefrahman.core.data.source.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ariefrahman.core.data.source.remote.network.ApiService
import com.ariefrahman.core.data.source.remote.response.ApiResponse
import com.ariefrahman.core.data.source.remote.response.CategoryResponse
import com.ariefrahman.core.data.source.remote.response.RecipeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class RemoteDataSource(private val apiService: ApiService) {
    fun getNewRecipe(): Flow<ApiResponse<List<RecipeResponse>>>{
        return flow {
            try {
                val response = apiService.getRecipe()
                val dataArray = response.results
                if(dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception){
                emit(ApiResponse.Error(e.message.toString()))
                e.printStackTrace()
                Log.e("RDS", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getCategory(): Flow<ApiResponse<List<CategoryResponse>>> = flow {
        try{
            val response = apiService.getCategory()
            val dataArray = response.results
            if(dataArray.isNotEmpty()){
                emit(ApiResponse.Success(dataArray))
            } else {
                emit(ApiResponse.Empty)
            }
        }catch (e: Exception){
            emit(ApiResponse.Error(e.message.toString()))
            e.printStackTrace()
            Log.e("RDS", e.toString())
        }
    }.flowOn(Dispatchers.IO)

}