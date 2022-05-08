package com.e.tmdb

import android.app.Application
import com.e.tmdb.module.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(
                listOf(
                    homeViewModelModule,
                    movieApiModule,
                    movieRepositoryModule,
                    movieDetailsViewModelModule,
                    movieDetailsRepositoryModule,
                    databaseModule,
                    httpClientModule
                )
            )
        }

    }
}