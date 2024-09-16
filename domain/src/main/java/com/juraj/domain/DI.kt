package com.juraj.domain

import com.juraj.domain.breweries.GetBreweriesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetBreweriesUseCase(get()) }
}