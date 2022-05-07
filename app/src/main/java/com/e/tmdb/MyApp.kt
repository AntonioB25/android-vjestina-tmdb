package com.e.tmdb

import android.app.Application
import com.e.tmdb.module.homeViewModelModule
import com.e.tmdb.module.movieApiModule
import com.e.tmdb.module.movieDetailsViewModelModule
import com.e.tmdb.module.movieRepositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(listOf(homeViewModelModule, movieApiModule, movieRepositoryModule, movieDetailsViewModelModule))
        }

    }
}