package com.juraj.data.api

import com.juraj.model.model.remote.BreweryRemote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BreweryApi {

    @GET("breweries")
    suspend fun getBreweries(
        @Query(value="page") page: Int,
        @Query(value="per_page") size: Int
    ): Response<List<BreweryRemote>>
}