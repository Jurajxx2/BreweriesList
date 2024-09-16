package com.juraj.breweries.presentation.breweries.adapter

import androidx.recyclerview.widget.DiffUtil
import com.juraj.model.model.Brewery

object BreweryComparator : DiffUtil.ItemCallback<Brewery>() {
  override fun areItemsTheSame(oldItem: Brewery, newItem: Brewery): Boolean {
    return oldItem.id == newItem.id
  }

  override fun areContentsTheSame(oldItem: Brewery, newItem: Brewery): Boolean {
    return oldItem.breweryType == newItem.breweryType &&
            oldItem.city == newItem.city &&
            oldItem.name == newItem.name &&
            oldItem.street == newItem.street &&
            oldItem.address2 == newItem.address2 &&
            oldItem.address3 == newItem.address3 &&
            oldItem.country == newItem.country &&
            oldItem.countyProvince == newItem.countyProvince &&
            oldItem.createdAt == newItem.createdAt &&
            oldItem.latitude == newItem.latitude &&
            oldItem.longitude == newItem.longitude &&
            oldItem.phone == newItem.phone &&
            oldItem.postalCode == newItem.postalCode &&
            oldItem.state == newItem.state &&
            oldItem.updatedAt == newItem.updatedAt &&
            oldItem.websiteURL == newItem.websiteURL
  }
}