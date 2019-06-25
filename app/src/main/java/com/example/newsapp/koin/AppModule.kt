package com.example.newsapp.koin

import com.example.newsapp.ui.MainViewModel
import com.example.newsapp.ui.detail.ArticlesViewModel
import com.google.gson.Gson
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { Gson() }
    viewModel { MainViewModel(get()) }
    viewModel { ArticlesViewModel(get()) }
}