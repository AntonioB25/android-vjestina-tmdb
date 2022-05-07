package com.e.tmdb.module


import com.e.tmdb.networking.MovieApi
import com.e.tmdb.networking.MovieApiImpl
import com.e.tmdb.respository.MovieRepository
import com.e.tmdb.respository.MovieRepositoryImpl
import com.e.tmdb.viewModel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieApiModule = module {
    single { MovieApiImpl() }
    single<MovieApi> {MovieApiImpl()}
}

val movieRepositoryModule = module{
    single { MovieRepositoryImpl(get()) }
    single<MovieRepository> {MovieRepositoryImpl(get())}
}

val homeViewModelModule = module {
    viewModel {
        HomeViewModel(get())
    }
}