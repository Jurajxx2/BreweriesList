package com.juraj.model.model

class Brewery(
    val id: String,
    val name: String,
    val breweryType: String?,
    val street: String?,
    val address2: String? = null,
    val address3: String? = null,
    val city: String?,
    val state: String?,
    val countyProvince: String? = null,
    val postalCode: String?,
    val country: String?,
    val longitude: String?,
    val latitude: String?,
    val phone: String?,
    val websiteURL: String?,
    val updatedAt: String?,
    val createdAt: String?
)