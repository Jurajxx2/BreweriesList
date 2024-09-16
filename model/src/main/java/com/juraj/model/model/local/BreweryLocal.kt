package com.juraj.model.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "breweries")
class BreweryLocal(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "brewery_type")
    val breweryType: String? = null,
    @ColumnInfo(name = "street")
    val street: String? = null,
    @ColumnInfo(name = "address_2")
    val address2: String? = null,
    @ColumnInfo(name = "address_3")
    val address3: String? = null,
    @ColumnInfo(name = "city")
    val city: String? = null,
    @ColumnInfo(name = "state")
    val state: String? = null,
    @ColumnInfo(name = "county_province")
    val countyProvince: String? = null,
    @ColumnInfo(name = "postal_code")
    val postalCode: String? = null,
    @ColumnInfo(name = "country")
    val country: String? = null,
    @ColumnInfo(name = "longitude")
    val longitude: String? = null,
    @ColumnInfo(name = "latitude")
    val latitude: String? = null,
    @ColumnInfo(name = "phone")
    val phone: String? = null,
    @ColumnInfo(name = "website_url")
    val websiteURL: String? = null,
    @ColumnInfo(name = "updated_at")
    val updatedAt: String? = null,
    @ColumnInfo(name = "created_at")
    val createdAt: String? = null
)