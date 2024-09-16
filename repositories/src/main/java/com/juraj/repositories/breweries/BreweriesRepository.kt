package com.juraj.repositories.breweries

import com.juraj.model.model.Brewery
import kotlinx.coroutines.flow.Flow

interface BreweriesRepository {

    suspend fun loadBrewery(breweryId: String): Brewery
    suspend fun loadBreweries(page: Int, size: Int): List<Brewery>
}