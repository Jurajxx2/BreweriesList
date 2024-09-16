package com.juraj.repositories.breweries.impl

import com.juraj.data.api.BreweryApi
import com.juraj.data.local.BreweryDao
import com.juraj.model.model.Brewery
import com.juraj.model.model.transformations.brewery.BreweryTransformations
import com.juraj.repositories.breweries.BreweriesRepository

class BreweriesRepositoryImpl(
    private val breweryApi: BreweryApi,
    private val breweryDao: BreweryDao,
) : BreweriesRepository {

    override suspend fun loadBrewery(breweryId: String): Brewery {
        return BreweryTransformations.fromLocal(breweryDao.getBreweryById(breweryId))
    }

    override suspend fun loadBreweries(page: Int, size: Int): List<Brewery> {
        val breweriesRemote = breweryApi.getBreweries(page, size)
        val breweries = breweriesRemote.body()?.map { BreweryTransformations.fromRemote(it) } ?: emptyList()
        breweryDao.insertBrewery(breweries.map { BreweryTransformations.toLocal(it) })
        return breweries
    }
}