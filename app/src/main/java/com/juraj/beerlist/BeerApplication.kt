package com.juraj.beerlist

import android.app.Application
import com.juraj.breweries.breweriesModule
import com.juraj.data.dataModule
import com.juraj.domain.useCaseModule
import com.juraj.repositories.repositoriesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

class BeerApplication: Application() {

    private val appModule = module {
        includes(dataModule, repositoriesModule, useCaseModule)
        includes(breweriesModule)
    }

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@BeerApplication)
            androidLogger()
            modules(appModule)
        }
    }
}