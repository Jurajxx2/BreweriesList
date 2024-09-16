package com.juraj.domain.breweries

import com.juraj.repositories.breweries.BreweriesRepository

class GetBreweriesUseCase(
    private val breweriesRepository: BreweriesRepository
) {
    suspend fun getBrewery(id: String) = breweriesRepository.loadBrewery(id)
    suspend fun getBreweries(page: Int, size: Int) = breweriesRepository.loadBreweries(page, size)
}