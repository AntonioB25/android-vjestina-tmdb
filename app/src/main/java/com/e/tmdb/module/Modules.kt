package com.e.tmdb.module


import com.e.tmdb.database.FavouritesDatabase
import com.e.tmdb.networking.ApiModule
import com.e.tmdb.networking.MovieApi
import com.e.tmdb.networking.MovieApiImpl
import com.e.tmdb.respository.MovieDetailsRepository
import com.e.tmdb.respository.MovieDetailsRepositoryImpl
import com.e.tmdb.respository.MovieRepository
import com.e.tmdb.respository.MovieRepositoryImpl
import com.e.tmdb.viewModel.HomeViewModel
import com.e.tmdb.viewModel.MovieDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val httpClientModule = module {
    single { ApiModule.httpClient }
}

val movieApiModule = module {
    single { MovieApiImpl(get()) }
    single<MovieApi> { MovieApiImpl(get()) }
}

val movieRepositoryModule = module {
    single { MovieRepositoryImpl(get(), get()) }
    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
}

val movieDetailsRepositoryModule = module {
    single { MovieDetailsRepositoryImpl(get()) }
    single<MovieDetailsRepository> { MovieDetailsRepositoryImpl(get()) }
}

val homeViewModelModule = module {
    viewModel {
        HomeViewModel(get())
    }
}

val movieDetailsViewModelModule = module {
    viewModel {
        MovieDetailsViewModel(get())
    }
}

val databaseModule = module {
    single { FavouritesDatabase(mutableListOf()) }
}