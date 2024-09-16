package com.juraj.repositories

import com.juraj.repositories.breweries.BreweriesRepository
import com.juraj.repositories.breweries.impl.BreweriesRepositoryImpl
import org.koin.dsl.module

val repositoriesModule = module {
    factory<BreweriesRepository> { BreweriesRepositoryImpl(get(), get()) }
}