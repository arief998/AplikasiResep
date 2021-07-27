package com.ariefrahman.myrecipe.di

import com.ariefrahman.core.domain.usecase.RecipeInteractor
import com.ariefrahman.core.domain.usecase.RecipeUseCase
import com.ariefrahman.myrecipe.ui.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<RecipeUseCase> { RecipeInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}