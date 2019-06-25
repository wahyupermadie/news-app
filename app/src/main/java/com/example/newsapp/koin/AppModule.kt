package com.example.newsapp.koin

import com.example.newsapp.service.network.repository.NewsRepository
import com.example.newsapp.ui.MainViewModel
import com.google.gson.Gson
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { Gson() }
    viewModel { MainViewModel(get()) }
    factory { NewsRepository(get(),get()) }
}