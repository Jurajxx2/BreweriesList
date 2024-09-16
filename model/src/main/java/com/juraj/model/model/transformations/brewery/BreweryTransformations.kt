package com.juraj.model.model.transformations.brewery

import com.juraj.model.model.Brewery
import com.juraj.model.model.local.BreweryLocal
import com.juraj.model.model.remote.BreweryRemote

object BreweryTransformations {
    fun fromRemote(remote: BreweryRemote): Brewery {
        return Brewery(
            remote.id,
            remote.name,
            remote.breweryType,
            remote.street,
            remote.address2,
            remote.address3,
            remote.city,
            remote.state,
            remote.countyProvince,
            remote.postalCode,
            remote.country,
            remote.longitude,
            remote.latitude,
            remote.phone,
            remote.websiteURL,
            remote.updatedAt,
            remote.createdAt
        )
    }
    
    fun toLocal(brewery: Brewery): BreweryLocal {
        return BreweryLocal(
            brewery.id,
            brewery.name,
            brewery.breweryType,
            brewery.street,
            brewery.address2,
            brewery.address3,
            brewery.city,
            brewery.state,
            brewery.countyProvince,
            brewery.postalCode,
            brewery.country,
            brewery.longitude,
            brewery.latitude,
            brewery.phone,
            brewery.websiteURL,
            brewery.updatedAt,
            brewery.createdAt
        )
    }

    fun fromLocal(breweryLocal: BreweryLocal): Brewery {
        return Brewery(
            breweryLocal.id,
            breweryLocal.name,
            breweryLocal.breweryType,
            breweryLocal.street,
            breweryLocal.address2,
            breweryLocal.address3,
            breweryLocal.city,
            breweryLocal.state,
            breweryLocal.countyProvince,
            breweryLocal.postalCode,
            breweryLocal.country,
            breweryLocal.longitude,
            breweryLocal.latitude,
            breweryLocal.phone,
            breweryLocal.websiteURL,
            breweryLocal.updatedAt,
            breweryLocal.createdAt
        )
    }
}

