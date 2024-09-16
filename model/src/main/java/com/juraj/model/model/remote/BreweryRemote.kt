package com.juraj.model.model.remote

import com.google.gson.annotations.SerializedName

class BreweryRemote(
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("brewery_type")
    val breweryType: String? = null,

    val street: String? = null,

    @SerializedName("address_2")
    val address2: String? = null,

    @SerializedName("address_3")
    val address3: String? = null,

    @SerializedName("city")
    val city: String? = null,

    @SerializedName("state")
    val state: String? = null,

    @SerializedName("county_province")
    val countyProvince: String? = null,

    @SerializedName("postal_code")
    val postalCode: String? = null,

    @SerializedName("country")
    val country: String? = null,

    @SerializedName("longitude")
    val longitude: String? = null,

    @SerializedName("latitude")
    val latitude: String? = null,

    @SerializedName("phone")
    val phone: String? = null,

    @SerializedName("website_url")
    val websiteURL: String? = null,

    @SerializedName("updated_at")
    val updatedAt: String? = null,

    @SerializedName("created_at")
    val createdAt: String? = null
)