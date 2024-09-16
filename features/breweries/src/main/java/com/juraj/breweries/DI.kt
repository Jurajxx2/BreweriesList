package com.juraj.breweries

import com.juraj.breweries.presentation.breweries.BreweriesPagingSource
import com.juraj.breweries.presentation.breweries.BreweriesViewModel
import com.juraj.breweries.presentation.brewerydetail.BreweryDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val breweriesModule = module {
    factory { BreweriesPagingSource(get()) }
    viewModel { BreweriesViewModel(get()) }
    viewModel { BreweryDetailViewModel(get()) }
}