package com.ariefrahman.core.di

import com.ariefrahman.core.data.source.remote.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://masak-apa.tomorisakura.vercel.app")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    retrofit.create(ApiService::class.java)
}